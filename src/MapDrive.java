import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapDrive {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
       Map<Integer,Integer> map = new HashMap<>();
        try  (Scanner scan  =new Scanner(new BufferedReader( new FileReader("Data.txt")))) {
            int value = 0;
            while (scan.hasNextLine()) {
                map.put(Integer.parseInt(scan.nextLine()),value);
                value++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Map Adding time:-  " + (end-start));



        start = System.currentTimeMillis();
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader("newData.txt") ))){
            while (scan.hasNextLine()){
                map.get(Integer.parseInt(scan.nextLine()));

            }
        }
        end = System.currentTimeMillis();
        System.out.println("Map Random searching time:- " + (end-start));


      start = System.currentTimeMillis();

    try(Scanner scan = new Scanner(new BufferedReader(new FileReader("Data.txt")));
         Scanner scan2 = new Scanner(new BufferedReader(new FileReader("newData.txt")))){
         while (scan.hasNextLine()){
             map.replace(Integer.parseInt(scan.nextLine()),Integer.parseInt(scan2.nextLine()));
         }
     }
     end = System.currentTimeMillis();
        System.out.println("Map Updating time:- " + (end-start));



        start = System.currentTimeMillis();

        map.toString();
        end = System.currentTimeMillis();

        System.out.println("Map Time it takes to print :- " + (end-start) );




        start = System.currentTimeMillis();
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader("newData.txt")))){
            while (scan.hasNextLine()) {
                map.remove(Integer.parseInt(scan.nextLine()));
            }


        }
        end = System.currentTimeMillis();
        System.out.println("Map Time it takes to remove :- " + (end-start));









    }
}