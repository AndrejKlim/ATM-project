package atm.project.service;


import atm.project.model.Account;

public interface ATMService {
    int getBalance(Account acc);
    void withdraw(int amount, Account acc);
    void putMoney(int amount, Account acc);

}
