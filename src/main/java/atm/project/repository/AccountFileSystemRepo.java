package atm.project.repository;


import atm.project.model.Account;

public interface AccountFileSystemRepo {
    Account getAccount(String cardNumber);
    void updateAcc(Account acc);
}
