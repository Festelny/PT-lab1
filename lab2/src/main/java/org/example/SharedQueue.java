package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {

    private final Queue<Integer> taskQueue;

    public SharedQueue() {
        this.taskQueue = new LinkedList<>();
    }

    public synchronized void addTask(int task){
        this.taskQueue.add(task);
        notify();
    }

    public synchronized Integer getTask() throws InterruptedException {
        while (taskQueue.isEmpty()){
            wait();
        }
        return taskQueue.poll();
    }
}
