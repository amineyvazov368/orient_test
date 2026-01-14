package selfStudy.BankAccount;

public class BankAccount {
    private int id;
    private String owner;
    private int balance;

    public BankAccount(int id, String owner, int balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        if (amount<=0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", new balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (amount<=0){
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (balance>amount){
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", new balance: " + balance);

        }else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds for withdrawal of " + amount);
        }
    }
}
