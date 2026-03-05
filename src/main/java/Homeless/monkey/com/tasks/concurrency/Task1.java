package Homeless.monkey.com.tasks.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1 {
    static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        BlockingQueue<Integer> queue = new BlockingQueue<>(3);

        for (int i = 0; i < 5; i++) {
            executor.submit(()-> {
                try {queue.enqueue(5);}
                catch (InterruptedException e) {throw new RuntimeException(e);}
            });
        }

        for (int i = 0; i < 5; i++) {
            executor.submit(()-> {
                try {queue.dequeue();}
                catch (InterruptedException e) {throw new RuntimeException(e);}
            });
        }

        executor.close();
    }
}
