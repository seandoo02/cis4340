/*OBJ03-J. Prevent heap pollution */

/*Noncompliant Code Example*/
class ListUtility {
  private static void addToList(List list, Object obj) {
    list.add(obj); // Unchecked warning
  }
 
  public static void main(String[] args) {
    List<String> list = new ArrayList<String> ();
    addToList(list, 42);
    System.out.println(list.get(0));  // Throws ClassCastException
  }
}

/*Compliant Solution (Parameterized Collection) */
class ListUtility {
  private static void addToList(List<String> list, String str) {
    list.add(str);     // No warning generated
  }
 
  public static void main(String[] args) {
    List<String> list = new ArrayList<String> ();
    addToList(list, "42");
    System.out.println(list.get(0));
  }
}