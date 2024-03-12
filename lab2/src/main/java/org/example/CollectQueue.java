package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class CollectQueue {

    Queue<String> collectQueue;

    public CollectQueue() {
        this.collectQueue = new LinkedList<>();
    }

    public synchronized void addResult(String result){
        collectQueue.add(result);
    }

    public String getResult(){
        return collectQueue.poll();
    }

    @Override
    public String toString() {
        return "CollectQueue{" +
                "collectQueue=" + collectQueue +
                '}';
    }
}
