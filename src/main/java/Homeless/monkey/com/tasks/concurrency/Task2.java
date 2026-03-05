package Homeless.monkey.com.tasks.concurrency;

public class Task2 {
    public static void main(String[] args) {
        ComplexTaskExecutor taskExecutor = new ComplexTaskExecutor();

        Runnable testRunnable = () -> {
            taskExecutor.executeTasks(5);
        };

        Thread thread1 = new Thread(testRunnable, "TestThread-1");
        Thread thread2 = new Thread(testRunnable, "TestThread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
