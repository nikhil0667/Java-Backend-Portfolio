package ExcutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
      ShareObject shareObject = new ShareObject();
      Thread wrongThread = new Thread(shareObject::setFlag);
      Thread rightThread = new Thread(shareObject::printFlag);
      wrongThread.start();
      rightThread.start();
//        for (int i = 1; i <= 10; i++) {
//            int fin = i;
//            executorService.submit(() -> {
//
//                try {
//                    System.out.println(factorail(fin));
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//            });
//          }
//        executorService.shutdown();
//
//        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static int factorail(int i) throws InterruptedException {
        Thread.sleep(2000);
        int result = 1;
        if (i == 0) {
            return result;
        } else {
            for (int j = 1; j <= i; j++) {
                result *= j;
            }
        }
        return result;
    }
}
class ShareObject{
    private boolean isFlag = false;
    public  void setFlag(){
        this.isFlag = true;
    }
    public  void printFlag() {
        while (!isFlag) {
        }
        System.out.println("Flag is set");
    }
}