public class Account {
    private double balance;

    public Account(double initBalance) {
        balance = initBalance;
    }

    public double getBalance() {
        return balance;
    }

    // setor: jumlah harus lebih dari 0
    public boolean deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            return true;
        }
        return false;
    }

    // tarik: saldo harus cukup
    public boolean withdraw(double amt) {
        if (amt > 0 && balance >= amt) {
            balance -= amt;
            return true;
        }
        return false;
    }
}
