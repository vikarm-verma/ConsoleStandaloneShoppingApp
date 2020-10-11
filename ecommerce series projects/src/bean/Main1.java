package bean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Java Program to remove an element while iterating over ArrayList
 */

public class Main1 {

  public static void main(String[] args) throws Exception {

    List<String> loans = new ArrayList<>();
    loans.add("personal loan");
    loans.add("home loan");
    loans.add("auto loan");
    loans.add("credit line loan");
    loans.add("mortgage loan");
    loans.add("gold loan");
    loans.add("personal loan");

    // printing ArrayList before removing any element
    System.out.println(loans);

    // removing element using ArrayList's remove method during iteration
    // This will throw ConcurrentModification
    int i=0;
    Iterator<String> itr = loans.iterator();
    while (itr.hasNext()) {
      String loan = itr.next();
    
      if (loan.equals("personal loan")) {
      i++;
    	
    	  if(i==1)
    	  {
    		  itr.remove();
    	  }  
      }
    }

    // printing ArrayList after removing an element
    System.out.println(loans);
  }

  }



