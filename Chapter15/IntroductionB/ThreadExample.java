package Chapter15.IntroductionB;

public class ThreadExample extends Thread {
    int count = 0;

    public void run() {
        System.out.println("Thread starting.");
        while (count < 5) {
            try {
                Thread.sleep(500);
                System.out.println("In this thread count is: " + count);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread terminating.");
    }
}
