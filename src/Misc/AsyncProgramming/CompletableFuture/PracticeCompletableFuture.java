package Misc.AsyncProgramming.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class PracticeCompletableFuture {

    private static void concatenateNames() {
        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> "Karan");
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> "Gupta");
        firstName
                .thenCombine(lastName, (fn, ls) -> fn.concat(" ").concat(ls))
                .thenAccept(System.out::println);
    }

    private static void printPostFetchingFiles() {
        CompletableFuture<String> imageDownload = CompletableFuture.supplyAsync(() -> "Image downloaded");
        CompletableFuture<String> userDetails = CompletableFuture.supplyAsync(() -> "User Details Fetched");
        CompletableFuture<String> config = CompletableFuture.supplyAsync(() -> "Config loaded");

        CompletableFuture<Void> all = CompletableFuture.allOf(imageDownload, userDetails, config);

        all.thenRun(() -> {
            try {
                System.out.println(imageDownload.get());
                System.out.println(userDetails.get());
                System.out.println(config.get());
                System.out.println("All tasks done");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static void simulateException(){
        CompletableFuture future = CompletableFuture.supplyAsync(()-> {
            throw new RuntimeException("Mock error");
        });

        

    }


    public static void main(String[] args) {
//        concatenateNames();
//        printPostFetchingFiles();

    }
}
