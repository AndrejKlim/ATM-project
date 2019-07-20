package atm.project.service;


import atm.project.model.Account;
import atm.project.repository.AccountFileSystemRepo;
import atm.project.repository.AccountFileSystemRepoImpl;

public class ATMServiceImpl implements ATMService {

    private int atmCashBalance;
    private final AccountFileSystemRepoImpl repository;

    public ATMServiceImpl(AccountFileSystemRepoImpl repository, int atmCashBalance)
    {
        this.repository = repository;
        this.atmCashBalance = atmCashBalance;
    }


    public int getBalance(Account acc) {
        System.out.println("Account balance: " + acc.getBalance());
        return acc.getBalance();
    }


    public void withdraw(int amount, Account acc) {
        int cash = acc.getBalance();
        if ((atmCashBalance - amount) > 0) {
            if (amount < cash) {
                atmCashBalance -= amount;
                acc.setBalance(cash - amount);
                repository.updateAcc(acc);
                getBalance(acc);
                System.out.println(amount + " successfully withdrawed");
            } else {
                System.out.println("Not enough money in the account for the transaction");
            }
        } else {
            System.out.println("Not enough money in an ATM to conduct a transaction");
        }
        ;
    }


    public void putMoney(int amount, Account acc) {
        int cash = acc.getBalance();
        if (amount < 1000000) {
            atmCashBalance += amount;
            acc.setBalance(cash + amount);
            repository.updateAcc(acc);
            getBalance(acc);
            System.out.println(amount + " successfully put");
        }else {
            System.out.println("Too much money to put");
        }
    }

    public int getAtmCashBalance() {
        return atmCashBalance;
    }
}
