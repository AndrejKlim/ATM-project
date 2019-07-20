package atm.project.model;

public class Account {
    private int balance;
    private final String cardNumber;
    private final String pin;
    private boolean isCardBlocked;

    public Account(String cardNumber, String pin, int balance) {
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public boolean isCardBlocked() {
        return isCardBlocked;
    }

    public void setCardBlocked(boolean cardBlocked) {
        this.isCardBlocked = cardBlocked;
    }
}
