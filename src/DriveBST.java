import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class DriveBST {
    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        long end;
        long total;
        BST<Integer> tree = new BST<>();

        try  (Scanner scan  =new Scanner(new BufferedReader( new FileReader("Data.txt")))) {
            while (scan.hasNextLine()) {
                tree.add(Integer.parseInt(scan.nextLine()));
            }
        }
        end= System.nanoTime();
        total = (end -start)/1000000;

        System.out.println("BST Adding time:-  " + total + "ms");



        start = System.nanoTime();
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader("newData.txt") ))){
            while (scan.hasNextLine()){
                tree.contains(Integer.parseInt(scan.nextLine()));

            }
        }
        end = System.nanoTime();
        total = (end -start)/1000000;
        System.out.println("BST Random searching time:- " + total + "ms");


        start = System.nanoTime();

     try(Scanner scan = new Scanner(new BufferedReader(new FileReader("Data.txt")));
         Scanner scan2 = new Scanner(new BufferedReader(new FileReader("newData.txt")))){
         while (scan.hasNextLine()){
             if(!scan.nextLine().equals(scan2.nextLine()))
               tree.update(Integer.parseInt(scan.nextLine()),Integer.parseInt(scan2.nextLine()));
         }
     }
     end = System.nanoTime();
        total = (end -start)/1000000;
        System.out.println("BST Updating time:- " + total + "ms");



        start = System.nanoTime();
        tree.traverse();
        end = System.nanoTime();
        total = (end -start)/1000000;

        System.out.println("BST Time it takes to sort and print :- " + total + "ms");




        start = System.nanoTime();
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader("newData.txt")))){
            while (scan.hasNextLine()) {
                tree.remove(Integer.parseInt(scan.nextLine()));
            }


        }
        end = System.nanoTime();
        total = (end -start)/1000000;

        System.out.println("BST Time it takes to remove :- " + total + "ms");
        System.out.println("size after removing :- "+ tree.size());










    }
}
