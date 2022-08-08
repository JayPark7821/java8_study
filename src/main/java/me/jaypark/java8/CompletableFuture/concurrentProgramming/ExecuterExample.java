package me.jaypark.java8.CompletableFuture.concurrentProgramming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterExample {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(() -> {
//            System.out.println("Thread" + Thread.currentThread().getName());
//        });
//        executorService.shutdown();
////        executorService.shutdownNow();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("hello "));
        executorService.submit(getRunnable("Jay "));
        executorService.submit(getRunnable("the "));
        executorService.submit(getRunnable("java "));
        executorService.submit(getRunnable("thread "));

        executorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> {
            System.out.println(message + Thread.currentThread().getName());

        };
    }

}
