package Misc.AsyncProgramming.CompletableFuture;


//Java program to demonstrate the use of the CompletableFuture

 import java.util.concurrent.CompletableFuture;

public class AsyncCallbackWithCompletableFuture {

//    Line-by-line:
//    Runs a task that sleeps for 200ms and then returns a string.
//    thenAccept() registers a non-blocking callback that prints the result.
//    The main thread sleeps 300ms to give time for the async task and callback to finish.
//    Output: "The Result: Hello, CompletableFuture!"
//   ⚠️ If Thread.sleep(300) was too short, the app might exit before the async task finishes.

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, CompletableFuture!";
        });
        future.thenAccept(result -> System.out.println("The Result: " + result));
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}