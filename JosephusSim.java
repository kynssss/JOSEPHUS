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
         size = 0;
         // make the ring circular by attaching last node's next to front
         while(file.hasNextLine()) {
            String name = file.nextLine().trim();
            if(!name.isEmpty()) {
               add(name);
            }
         }
         file.close();
         PersonNode last = circle;
         while(last.next != null) {
            last = last.next;
         }   
         last.next = circle;   
         // remember the last node as the one in front of the next to get eliminated
         track = last;
         
         // generate, print, and save the random elimination count
         Random rand = new Random();
         eliminationCount = rand.nextInt(size / 2) + 1;
         System.out.println("=== Elimination count is " + eliminationCount + " ===");
      } catch(FileNotFoundException e) {
         System.out.println("Something went wrong with " + fileName);
      }
   }
   
   // optional helper method for constructing the circle
   private void add(String val) {
      PersonNode newNode = new PersonNode(val);
      
      if(circle == null) {
         circle = newNode;
      } else {
         PersonNode cur = circle;
         while(cur.next != null) {
            cur = cur.next;
         }
         cur.next = newNode;
      }
      size++;
   }
   
   public void eliminate() {
      if(size <= 1) {
         return;
      }
     
      PersonNode cur = circle;
      // Get last
      for(int i = 1; i < eliminationCount - 1; i++) {
         cur = cur.next;   
      } 
      PersonNode last = cur;
      PersonNode eliminationNode = last.next; 
      // print who will be eliminated
      System.out.println(eliminationNode.name + " eliminated!");
      PersonNode newFront = eliminationNode.next;
      last.next = newFront;
      circle = newFront;
      size--;      
   }
   
   public boolean isOver() {
      // check if there's only one person left in the circle
      return size == 1;
   }
   
   public String toString() {
      PersonNode cur = circle;
      String result = "";
      // if there's only one person left, print them as the last survivor
      if(size == 1) {
         result = circle.name + " is the last survivor!";
      }
      // print the remaining survivors (watch out for infinite loop since list is circular)
      result = "Remaining survivors: ";
      for(int i = 1; i <= size; i++) {
         result += i + "-" + cur.name;
         if(i < size) {
            result += ", ";
         }
         cur = cur.next;   
      }
      return result;
   }

}