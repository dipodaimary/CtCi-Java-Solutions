package Chapter15.IntroductionToLocks;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass extends Thread {
    private NoLockATM noLockATM;
    private LockedATM lockedATM;
    public int delta = 0;
    private Lock completionLock;


    public MyClass(NoLockATM atm1, LockedATM atm2) {
        noLockATM = atm1;
        lockedATM = atm2;
        completionLock = new ReentrantLock();
    }

    public void run() {
        completionLock.lock();
        int[] operations = new int[50];
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            operations[i] = r.nextInt(50);
        }
        for (int op : operations) {
            delta += op;
            if (op < 0) {

                int val = op * -1;
                noLockATM.withdraw(val);
                lockedATM.withdraw(val);
            } else {
                int val = op;
                noLockATM.deposit(val);
                lockedATM.deposit(val);
            }
        }
        completionLock.unlock();
    }

    public void waitUntilDone() {
        completionLock.lock();
        completionLock.unlock();
    }
}
