package selfStudy.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1, "Amin", 1000);
        BankAccount account2 = new BankAccount(2, "Leyla", 500);


        Thread t1 = new Thread(new BankCustomer(account1), "Customer-1");
        Thread t2 = new Thread(new BankCustomer(account1), "Customer-2");
        Thread t3 = new Thread(new BankCustomer(account2), "Customer-3");

        t1.start();
        t2.start();
        t3.start();
        System.out.println("Account 1: " + account1.getBalance());

    }
}
