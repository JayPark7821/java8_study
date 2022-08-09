package me.jaypark.java8.CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class CompletableFutureSampleTwo {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			System.out.println("hello " + Thread.currentThread().getName());
			return "hello";
		});

		CompletableFuture<String> future = hello.thenCompose(CompletableFutureSampleTwo::getWorld);
		System.out.println("future.get() = " + future.get());





		CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(() -> {
			System.out.println("hello1 " + Thread.currentThread().getName());
			return "hello1";
		});

		CompletableFuture<String> world1 = CompletableFuture.supplyAsync(() -> {
			System.out.println("world1 " + Thread.currentThread().getName());
			return "world1";
		});

		CompletableFuture<String> combine = hello1.thenCombine(world1, (h, w) -> {
			return h + " " + w;
		});

		System.out.println("combine = " + combine.get());


		CompletableFuture<Void> future1 = CompletableFuture.allOf(hello1, world1)
			.thenAccept(System.out::println);
		System.out.println("future1 = " + future1.get());

		List<CompletableFuture> futures = Arrays.asList(hello1, world1);
		CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

		CompletableFuture<List<Object>> results = CompletableFuture.allOf(futuresArray)
			.thenApply(v ->   futures.stream()
					.map(CompletableFuture::join)
					.collect(Collectors.toList()));


		results.get().forEach(System.out::println);

		boolean throwError = true;
		CompletableFuture<String> hell0 = CompletableFuture.supplyAsync(() -> {
			if (throwError) {
				throw new IllegalArgumentException();
			}

			System.out.println("hell0 " + Thread.currentThread().getName());
			return "hell0 ";
		}).exceptionally(ex -> {
			System.out.println("ex = " + ex);
			return "Error!!";
		});

		CompletableFuture<String> hell00 = CompletableFuture.supplyAsync(() -> {
			if (throwError) {
				throw new IllegalArgumentException();
			}

			System.out.println("hell0 " + Thread.currentThread().getName());
			return "hell0 ";
		}).handle((result, ex) ->{
			if (ex != null) {
				System.out.println("ex = " + ex);
				return "ERROR!";
			}
			return result;
		});




	}

	private static CompletableFuture<String> getWorld(String message) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("world " + Thread.currentThread().getName());
			return message + "world";
		});
	}





}
