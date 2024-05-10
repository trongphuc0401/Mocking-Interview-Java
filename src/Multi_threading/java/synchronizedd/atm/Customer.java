package Multi_threading.java.synchronizedd.atm;

public class Customer {
     private int balance = 1000;


     public Customer() {
         System.out.println("Your account balance are: " + balance);
     }

     public synchronized void withdraw(int amount) {
         System.out.println("Trading is processing withdraw: "+ amount);

         while (balance < amount) {
             System.out.println("Hey go deposit");

             try {
                 wait();
             }catch (InterruptedException e) {
                 System.out.println(e.toString());
             }
         }
         balance -=  amount;

         System.out.println("Withdraw success your account balance are: "+balance);
     }

     public synchronized void deposit(int amount) {
         System.out.println("Depositing.........."+ amount);

         balance += amount;
         System.out.println("Deposit success your account balance are: "+ balance);
         notifyAll();
     }

}
