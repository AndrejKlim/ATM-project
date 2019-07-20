package atm.project.ui;



import atm.project.model.Account;
import atm.project.repository.AccountFileSystemRepo;
import atm.project.repository.AccountFileSystemRepoImpl;
import atm.project.service.ATMService;
import atm.project.service.ATMServiceImpl;
import atm.project.utils.ValidationUtils;

import java.util.Scanner;



public class UI {
    private Scanner in;
    private Account acc;
    private AccountFileSystemRepoImpl accountRepository;
    private ATMService atm;
    private String number;
    private String pin;

    public UI(AccountFileSystemRepoImpl rep, ATMService atm) {
        this.accountRepository = rep;
        this.atm = atm;
        this.in = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Welcome to ui.ATM 24/7.");
        while (true) {
            System.out.print("Enter your card number in format XXXX-XXXX-XXXX-XXXX: ");
            number = in.next();
            if (ValidationUtils.isNumberValid(number) && ValidationUtils.isNumberExists(number, accountRepository)) {
                System.out.print("Enter pin: ");
                pin = in.next();
                Account account = accountRepository.getAccount(number);
                if (ValidationUtils.isPinValid(pin, account)) {
                    acc = account;
                    mainloop();
                    break;
                }else {
                    System.out.println("Incorrect pin");
                }
            }else {
                System.out.println("Incorrect card number");
            }
        }

    }

    public void mainloop(){
        System.out.println("Please, choose the operation:\n" +
                "To check your balance enter CHECK\n" +
                "To withdraw money enter WITHDRAW XXXX (replace XXXX with desired amount of money)\n" +
                "To put money into the account enter PUT XXXX (replace XXXX with your amount of money)");
        while (true){
            String[] command = in.nextLine().split(" ");
            if (command[0].equals("PUT")){
                int amount = Integer.parseInt(command[1]);
                atm.putMoney(amount,acc);
            }
            else  if (command[0].equals("WITHDRAW")){
                int amount = Integer.parseInt(command[1]);
                atm.withdraw(amount,acc);
            }
            else if (command[0].equals("CHECK")){
                atm.getBalance(acc);

            }else if(command[0].equals("ESC")){
                break;
            }else {
                System.out.println("Enter correct command");
            }
        }
    }

}




