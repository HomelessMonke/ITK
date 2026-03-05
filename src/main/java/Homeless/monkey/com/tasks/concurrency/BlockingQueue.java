package Homeless.monkey.com.tasks.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(T element) throws InterruptedException {
        while(queue.size()>=capacity){
            System.out.println("enqueue Засыпаем");
            wait();
        }

        queue.add(element);
        System.out.println("Успех enqueue");
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()){
            System.out.println("dequeue Засыпаем");
            wait();
        }

        T element = queue.remove();
        System.out.println("Успех dequeue");
        notifyAll();
        return element;
    }

    public int size() {return queue.size();}
}
