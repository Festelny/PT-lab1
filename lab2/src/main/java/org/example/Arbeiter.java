package org.example;

public class Arbeiter implements Runnable{

    private final SharedQueue taskQueue;
    private final CollectQueue collectQueue;

    public Arbeiter(SharedQueue taskQueue, CollectQueue collectQueue) {
        this.taskQueue = taskQueue;
        this.collectQueue = collectQueue;
    }
    @Override
    public void run(){
        while (true){
            try{
                int task= taskQueue.getTask();

                Thread.sleep(task*1000L);

                collectQueue.addResult("Task completed took:"+ task+"s");

            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
