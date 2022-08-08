package me.jaypark.java8.CompletableFuture.concurrentProgramming;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {

//        MyThread myThread = new MyThread();
//        myThread.start();

        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }


            System.out.println("hello = " +  Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
//                System.out.println("interrupted");
//                return;
            }


        });
        thread.start();

        System.out.println("Thread = " +Thread.currentThread().getName());
        thread.join();
        System.out.println("finished");
//        Thread.sleep(3000L);
//        thread.interrupt();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello = " + Thread.currentThread().getName());
        }
    }
}
