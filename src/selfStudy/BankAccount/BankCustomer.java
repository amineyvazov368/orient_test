package selfStudy.BankAccount;

public class BankCustomer implements Runnable{

    private BankAccount bankAccount;

    public BankCustomer(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int amount = (int) (Math.random()*100);
            if (Math.random()>0.5){
                bankAccount.deposit(amount);
            }else {
                bankAccount.withdraw(amount);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}
