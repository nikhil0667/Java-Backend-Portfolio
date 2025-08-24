package ThreadExample;

public class Main extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        Thread.currentThread().setName("MyThread");
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        System.out.println(main.getName());

        System.out.println(main.getState());
        main.start();
        System.out.println(main.getState());
        Thread.sleep(100);
    }
}

