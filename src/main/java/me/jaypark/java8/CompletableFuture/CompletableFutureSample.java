package me.jaypark.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureSample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> future = executorService.submit(() -> "hello");
		future.get();// get을 하기전까지는 아무것도 할 수 없다 blocking Call

		CompletableFuture<String> future1 = new CompletableFuture<>();
		future1.complete("jay");
		System.out.println(future1.get());

		CompletableFuture<String> future2 = CompletableFuture.completedFuture("jay");
		System.out.println(future2.get());

		CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
			System.out.println("hello " + Thread.currentThread().getName());
		});
		future3.get();

		CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
			System.out.println("hello " + Thread.currentThread().getName());
			return "hello";
		}).thenApply((s)-> {
			System.out.println(Thread.currentThread().getName());
			return s.toUpperCase();
		});
		future4.get();


		CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
			System.out.println("hello " + Thread.currentThread().getName());
			return "hello";
		},executorService).thenApplyAsync((s)-> {
			System.out.println(Thread.currentThread().getName());
			return s.toUpperCase();
		},executorService);
		future4.get();



	}
}
