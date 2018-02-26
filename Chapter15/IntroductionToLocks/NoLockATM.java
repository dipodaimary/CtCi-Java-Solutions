package Chapter15.IntroductionToLocks;

public class NoLockATM {
    private int balance = 100;

    public void NoLockATM() {

    }

    public int withdraw(int value) {
        int temp = balance;
        try {
            Thread.sleep(300);
            temp = balance - value;
            Thread.sleep(100);
            balance = temp;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return balance;
    }

    public int deposit(int value) {
        int temp = balance;
        try {
            Thread.sleep(300);
            temp += value;
            Thread.sleep(300);
            balance = temp;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public int getBalance() {
        return balance;
    }
}
