package Misc.AsyncProgramming.CompletableFuture;

import java.util.concurrent.*;

class CompletableFutureExample {
    public static void main(String[] args) throws Exception {

//        Line-by-line Explanation:
//        supplyAsync() runs a task in a background thread (default ForkJoinPool.commonPool()).
//        It returns a CompletableFuture<String>.
//        get() blocks the main thread until the result is available.
//        "Hello from CompletableFuture" is printed to the console.

        //    Example 1:
        CompletableFuture<String> greetingFuture
                = CompletableFuture.supplyAsync(() -> {
            // some async computation
            return "Hello from CompletableFuture";
        });

        greetingFuture.thenAccept(System.out::println);

//        System.out.println(greetingFuture.get()); // Incorrect, blocking


//    Example 2:
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1: " + Thread.currentThread().getName());
            return 42;
        }).thenRunAsync(() -> {
            // Always runs asynchronously, likely on different thread
            System.out.println("Step 2: " + Thread.currentThread().getName());
        });

    }
}