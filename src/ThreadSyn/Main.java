package ThreadSyn;



public class Main {
    public static void main(String[] args) {
//        BankAccount1 bankAccount = new BankAccount1();
//        Runnable runnable = () -> bankAccount.withdraw(70);
//        Thread thread = new Thread(runnable, "User - 1");
//        Thread thread1 = new Thread(runnable, "User - 2");
//        Thread thread2 = new Thread(runnable, "User - 3");
//        Thread thread3 = new Thread(runnable, "User - 4");
//
//thread.start();
//thread1.start();
//thread2.start();
//thread3.start();


       Student student = new Student() {
           @Override
           public String getBio(String name) {
               return  name +" Is Engneering ";
           }
       };
        System.out.println(student.getBio("Ram"));
Student student2 = (String name) -> {return name+"Is law Student";};
  System.out.println(student2.getBio("Ram"));
    }


}

