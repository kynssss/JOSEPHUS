import java.util.*;
import java.io.*;

public class JosephusSim {
   private PersonNode circle;     // a PersonNode pointer that tracks first node
   private int size;              // the number of people in the circle
   private int eliminationCount;  // the number to count to for elimination       
   private PersonNode track;      // a PersonNode pointer to help with elimination

   public JosephusSim(String fileName) {
      try {
         // load names from the file in order, generating a singly linked list of PersonNodes
         Scanner file = new Scanner(new File(fileName));
         
         // make the ring circular by attaching last node's next to front
         
         // remember the last node as the one in front of the next to get eliminated
         
         // generate, print, and save the random elimination count

      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
   }
   
   public void eliminate() {
      String eliminateName = "";
      ListNode temp = "";
      ListNode newFront = "";
      ListNode nexLast = "";
      // count to the elimination count
      for(int i = 0; i < eliminationCount; i++) {
         eliminationName = circle.name.next;   
      }  
      // Get new last
      for(int i = 0; i < eliminationCount - 1; i++) {
         newLast = circle.name.next;   
      }  
 
      // print who will be eliminated
      System.out.println(eliminationName + " eliminated!");
      // eliminate the person and update "front" of the circle and size
      newFront = eliminationName.next;
      eliminationName.next = null;
      newLast.next = null;
      
   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle
      return size == 1;
   }
   
   public String toString() {
      String result = "";
      // if there's only one person left, print them as the last survivor
      if(size == 1) {
         result = circle.name + " is the last survivor!";
      }
      // print the remaining survivors (watch out for infinite loop since list is circular)
      for(int i = 1; i <= size; i++) {
         result = i + "-" + circle.name + ", ";
      }
      return result;
   }

}