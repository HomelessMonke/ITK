package Homeless.monkey.com.tasks.streamAPI;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {

    private final int start;
    private final int end;
    private static final int THRESHOLD = 5;

    public FactorialTask(int start, int end) {
        if (start < 0)
            throw new IllegalArgumentException("Нельзя отрицательное число");

        if(end < start){
            this.end = start;
            this.start = end;
        } else {
            this.start = start;
            this.end = end;
        }
    }

    public FactorialTask(int n) {
        this(1, n);
    }

    @Override
    protected Long compute() {
        if ((end-start+1) <= THRESHOLD)
            return calculateFactorial(start, end);

        int mid = start + (end-start) / 2;

        FactorialTask firstTask = new FactorialTask(start, mid);
        FactorialTask secondTask = new FactorialTask(mid + 1, end);

        firstTask.fork();
        secondTask.fork();

        long firstResult = firstTask.join();
        long secondResult = secondTask.join();

        return firstResult * secondResult;
    }

    private long calculateFactorial(int start, int end){
        long result = 1;
        for (int i = start; i <= end; i++) {
            result *= i;
        }
        return result;
    }
}
