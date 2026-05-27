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
         Random rand = new Random();
         eliminationCount = rand.nextInt(size / 2) + 1;
      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
   }
   
   public void eliminate() {
      PersonNode eliminateName = null;
      PersonNode cur = circle;
      // count to the elimination count
      for(int i = 0; i < eliminationCount; i++) {
         eliminateName = circle.next;   
      } 
      //Get last
      while(cur.next != null) {
         cur = cur.next;
      }
      PersonNode last = cur;
      cur = circle;
      //Get new last
      for(int i = 0; i < eliminationCount - 1; i++) {
         cur = cur.next;
      }
      PersonNode newLast = cur;
      
      // print who will be eliminated
      System.out.println(eliminateName + " eliminated!");
      // eliminate the person and update "front" of the circle and size
      last.next = circle;                       // point last to front
      PersonNode newFront = eliminateName.next; // get new front
      newLast.next = newFront;                  // point new last to new front
      circle = newFront;
      
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