public class SynchronizedBankAppTask implements Runnable {
    private int balance = 1000;
    private int amount;
    private boolean isDeposit;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public void setDeposit(boolean deposit) {
        isDeposit = deposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            this.balance = this.balance + this.amount;
            System.out.println(Thread.currentThread().getName()+" deposit and balance="+this.balance);
        } else if (this.balance > this.amount) {
            this.balance = this.balance - this.amount;
            System.out.println(Thread.currentThread().getName()+" withdraw and balance="+this.balance);
        } else if (this.balance<this.amount) {
            System.out.println(Thread.currentThread().getName()+" no sufficient balance to withdraw="+this.amount);
        }

    }
}
