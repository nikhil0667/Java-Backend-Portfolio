package ExcutorFramework;

import java.util.Random;
import java.util.concurrent.*;
import java.util.random.RandomGenerator;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
//        ExecutorService executorService = Executors.newFixedThreadPool(9);
        Random random = new Random(1000);

        ScheduledExecutorService service =
                Executors.newScheduledThreadPool(3);

        service.scheduleAtFixedRate(() -> {
            int value = random.nextInt(100);
            System.out.println("Generated: " + value);
        }, 0 ,1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(() -> System.out.println("Hello"), 0, 1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(() -> System.out.println("W"), 0, 1, TimeUnit.SECONDS);

//        for (int i = 1; i < 10; i++) {
//
//            int finalI = i;
//          Future<?> future = executorService.submit(() -> System.out.println(
//                    finalI + " :- " + fact(finalI)));
//            System.out.println("H : - "+future.get());
//        }
//        executorService.shutdown();
//        try {
//            while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
//                System.out.println("Waiting for termination");
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(
//                    e);
//        }
//        System.out.println("Total Time :- " + (System.currentTimeMillis() - startTime));
//    }
//
//    public static int fact(int n) {
//
//        int result = 1;
//        for (int i = 1; i <= n; i++) {
//            result *= i;
//
//        }
//        return result;
    }

}
