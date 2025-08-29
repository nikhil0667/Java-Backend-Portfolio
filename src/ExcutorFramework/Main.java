package ExcutorFramework;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for (int i = 1; i < 10; i++) {

            int finalI = i;
          Future<?> future = executorService.submit(() -> System.out.println(
                    finalI + " :- " + fact(finalI)));
            System.out.println("H : - "+future.get());
        }
        executorService.shutdown();
        try {
            while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Waiting for termination");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(
                    e);
        }
        System.out.println("Total Time :- " + (System.currentTimeMillis() - startTime));
    }

    public static int fact(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;

        }
        return result;
    }

}
