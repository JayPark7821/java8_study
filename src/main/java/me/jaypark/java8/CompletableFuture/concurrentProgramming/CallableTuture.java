package me.jaypark.java8.CompletableFuture.concurrentProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableTuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };


        Callable<String> jay = () -> {
            Thread.sleep(5000L);
            return "jay";
        };

//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, jay));
//        for (Future<String> future : futures) {
//            System.out.println("future.get() = " + future.get());
//        }
        String s = executorService.invokeAny(Arrays.asList(hello, java, jay));
        System.out.println("s = " + s);

//        Future<String> helloFuture = executorService.submit(hello);
//        System.out.println("helloFuture = " + helloFuture.isDone());
//        System.out.println("Started!!");
//
//        String s = helloFuture.get(); // 블록킹 콜 기다린다!
//
//        System.out.println("helloFuture = " + helloFuture.isDone());
//        System.out.println("End!!!");
//        executorService.shutdown();

    }
}
