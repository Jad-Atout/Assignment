import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DriveLinkedList  {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        try  (Scanner scan  =new Scanner(new BufferedReader( new FileReader("Data.txt")))) {
            while (scan.hasNextLine()) {
                linkedList.add(Integer.parseInt(scan.nextLine()));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("LinkedList Adding time:-  " + (end-start));



        start = System.currentTimeMillis();
      try(Scanner scan = new Scanner(new BufferedReader(new FileReader("newData.txt") ))){
          while (scan.hasNextLine()){
              linkedList.indexOf(Integer.parseInt(scan.nextLine()));

          }
      }
      end = System.currentTimeMillis();
      System.out.println("LinkedList Random searching time:- " + (end-start));


       start = System.currentTimeMillis();

    try(Scanner scan = new Scanner(new BufferedReader(new FileReader("Data.txt")));
         Scanner scan2 = new Scanner(new BufferedReader(new FileReader("newData.txt")))){
         while (scan.hasNextLine()){
             linkedList.update(Integer.parseInt(scan.nextLine()),Integer.parseInt(scan2.nextLine()));
         }
     }
     end = System.currentTimeMillis();
        System.out.println("Updating time:- " + (end-start));



        start = System.currentTimeMillis();
      linkedList.sortList();
        linkedList.toString();
        end = System.currentTimeMillis();

        System.out.println(" LinkedList Time it takes to sort and print :- " + (end-start) );




     start = System.currentTimeMillis();
     try(Scanner scan = new Scanner(new BufferedReader(new FileReader("newData.txt")))){
         while (scan.hasNextLine()) {
             linkedList.remove(Integer.parseInt(scan.nextLine()));
         }


     }
     end = System.currentTimeMillis();
        System.out.println("LinkedList Time it takes to remove :- " + (end-start));


        System.out.println("size after removing :- "+ linkedList.size());






    }
}
