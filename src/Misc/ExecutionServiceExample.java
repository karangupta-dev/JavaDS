package Misc;

import java.util.concurrent.*;

public class ExecutionServiceExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> task = () -> {
            if (true) throw new RuntimeException("Something went wrong");
            return 100;
        };

        Future<Integer> future = executor.submit(task);

        try {
            future.get();
        } catch (ExecutionException e) {
            System.out.println("Caught: " + e.getCause());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            executor.shutdown();
        }

    }
}
