package account;

public class Account {


    private double balance;
    private int pin;

    public Account(int pin) {
        balance = 0;
        this.pin = pin;
    }

    public double checkBalance(int pin) {
        if (this.pin == pin) {
            return balance;
        } else {

            throw new IllegalArgumentException("the pin is not correct oga");


        }
    }


    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    public boolean withdraw(double amount, int pin) {
        if (this.pin == pin && amount > 0 && balance > amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

}
