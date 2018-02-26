package Chapter15.IntroductionA;

public class ExampleA {
    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();
        while (instance.count != 5) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Program terminating.");
    }
}
