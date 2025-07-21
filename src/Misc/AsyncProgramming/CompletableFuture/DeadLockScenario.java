package Misc.AsyncProgramming.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockScenario {

//    Line-by-line:
//    A thread pool with only 1 thread is created.
//
//    An outer async task is submitted to that pool.
//
//    Inside it, another async task is submitted to the same pool.
//
//    The outer task calls join() on the inner task → blocks the only thread in the pool.
//
//    But now the inner task never runs, because no thread is available → deadlock.


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Outer task
            CompletableFuture<Void> inner = CompletableFuture.runAsync(() -> {
                System.out.println("Inner task running");
            }, executor);

            inner.join();  // Blocking call — causes deadlock!
        }, executor);

        future.join(); // Also blocks
    }


}
