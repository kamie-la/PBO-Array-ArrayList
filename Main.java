import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        // data awal
        bank.addCustomer("Baiq", "Nur");
        bank.addCustomer("Saqinah", "Kamila");
        bank.getCustomer(0).setAccount(new Account(500000));
        bank.getCustomer(1).setAccount(new Account(1000000));

        System.out.println("=== ATM SEDERHANA ===");
        System.out.println("Jumlah nasabah: " + bank.getNumOfCustomers());
        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            Customer c = bank.getCustomer(i);
            System.out.println((i + 1) + ". " + c.getFirstName() + " " + c.getLastName());
        }

        System.out.print("Pilih nasabah (nomor): ");
        int pilih = input.nextInt() - 1;
        if (pilih < 0 || pilih >= bank.getNumOfCustomers()) {
            System.out.println("Nasabah tidak ditemukan.");
            return;
        }

        Customer nasabah = bank.getCustomer(pilih);
        Account akun = nasabah.getAccount(0);
        int menu;

        do {
            System.out.println("\nHalo, " + nasabah.getFirstName() + "!");
            System.out.println("1. Cek saldo");
            System.out.println("2. Setor tunai");
            System.out.println("3. Tarik tunai");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            menu = input.nextInt();

            if (menu == 1) {
                System.out.println("Saldo kamu: Rp" + akun.getBalance());
            } else if (menu == 2) {
                System.out.print("Jumlah setor: ");
                double jml = input.nextDouble();
                if (akun.deposit(jml)) {
                    System.out.println("Setor berhasil.");
                } else {
                    System.out.println("Setor gagal, jumlah tidak valid.");
                }
            } else if (menu == 3) {
                System.out.print("Jumlah tarik: ");
                double jml = input.nextDouble();
                if (akun.withdraw(jml)) {
                    System.out.println("Tarik berhasil.");
                } else {
                    System.out.println("Tarik gagal, saldo tidak cukup.");
                }
            } else if (menu != 0) {
                System.out.println("Tarik gagal, saldo tidak cukup.");
            }
        } while (menu != 0);

        System.out.println("Terima kasih!");
        input.close();
    }
}
