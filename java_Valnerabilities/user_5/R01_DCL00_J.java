/*DCL00_J Prevent class initialization cycles */
/*Noncompliant code Example */
public class Cycle {
    private final int balance;
    private static final Cycle c = new Cycle();
    private static final int deposit = (int) (Math.random() * 100); // Random deposit
   
    public Cycle() {
      balance = deposit - 10; // Subtract processing fee
    }
   
    public static void main(String[] args) {
      System.out.println("The account balance is: " + c.balance);
    }
  }
  

/*Correted Compliant Solution */
public class Cycle {
    private final int balance;
    private static final int deposit = (int) (Math.random() * 100); // Random deposit
    private static final Cycle c = new Cycle();  // Inserted after initialization of required fields
    public Cycle() {
      balance = deposit - 10; // Subtract processing fee
    }
   
    public static void main(String[] args) {
      System.out.println("The account balance is: " + c.balance);
    }
  }