/*VNA00-J. Ensure visibility when accessing shared primitive variables*/

/*Noncompliant Code Example */
final class ControlledStop implements Runnable {
    private boolean done = false;
    
    @Override public void run() {
      while (!done) {
        try {
          // ...
          Thread.currentThread().sleep(1000); // Do something
        } catch(InterruptedException ie) {
          Thread.currentThread().interrupt(); // Reset interrupted status
        }
      }   
    }
   
    public void shutdown() {
      done = true;
    }
  }

  /*Compliant Solution */
  final class ControlledStop implements Runnable {
    private volatile boolean done = false;
    
    @Override public void run() {
      while (!done) {
        try {
          // ...
          Thread.currentThread().sleep(1000); // Do something
        } catch(InterruptedException ie) {
          Thread.currentThread().interrupt(); // Reset interrupted status
        }
      }   
    }
   
    public void shutdown() {
      done = true;
    }
  }

