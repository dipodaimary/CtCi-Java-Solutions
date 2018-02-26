package Chapter15.IntroductionA;

public class RunnableThreadExample implements Runnable {
    public int count = 0;

    @Override
    public void run() {
        System.out.println("Runnable Thread Starting");
        while (count < 5) {
            try {
                Thread.sleep(500);
                System.out.println("Runnable Thread Count: " + count);
                count++;
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("Runnable Thread Interrupted.");
            }
        }
        System.out.println("Runnable thread terminating.");
    }
}
