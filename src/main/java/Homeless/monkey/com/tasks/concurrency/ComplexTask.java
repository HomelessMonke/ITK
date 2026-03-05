package Homeless.monkey.com.tasks.concurrency;

public class ComplexTask {

    public void execute(){
        try{
            System.out.println(Thread.currentThread().getName() + " START execute");
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " END execute");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
