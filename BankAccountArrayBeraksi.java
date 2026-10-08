import java.util.ArrayList;

public class BankAccountArrayBeraksi {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account(1001));
        accounts.add(new Account(1015));
        accounts.add(new Account(1729));
        accounts.add(1, new Account(1008));
        accounts.remove(0);

        System.out.println("Size: " + accounts.size());
        System.out.println("Expected: 3");
        System.out.println("First balance: " + accounts.get(0).getBalance());
        System.out.println("Expected: 1008.0");
        System.out.println("Last balance: " + accounts.get(accounts.size() - 1).getBalance());
        System.out.println("Expected: 1729.0");
    }
}
