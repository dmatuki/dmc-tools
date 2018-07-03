package org.dmc.concurency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
    Queue<String> queue = new LinkedList<>();
    ExecutorService producers = Executors.newFixedThreadPool(1);
    ExecutorService consumers = Executors.newFixedThreadPool(1);
    
    private synchronized void produce() {
        queue.add("item" + Math.random());
    }
    
    private synchronized String consume() {
        return queue.remove();
    }
    
    public void run() {
        producers.submit(this::produce);
        consumers.submit(this::consume);
    }
    
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        pc.run();
    }
}
