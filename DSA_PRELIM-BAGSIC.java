import java.util.Scanner;

public class DSA_PRELIM_BAGSIC {
   public static void main(String[] args) {
      Scanner read = new Scanner(System.in);
      System.out.println("Enter the number of strings: ");
      int str = read.nextInt();
      String[] arr = new String[str];
      System.out.println("Enter the strings: ");
      for (int i = 0; i < str; i++) {
         arr[i] = read.next();
      }

      System.out.println("Unsorted String: ");
      for (int i = 0; i < str; i++) {
         System.out.print("[" + arr[i] + "] ");
      }

      // Bubble sort
      for (int i = 0; i < str - 1; i++) {
         for (int j = 0; j < str - i - 1; j++) {
            if (arr[j].compareTo(arr[j + 1]) > 0) {
               String temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
            }
         }
      }

      System.out.println("\nSorted String using Bubble sort: ");
      for (int i = 0; i < str; i++) {
         System.out.print("[" + arr[i] + "] ");
      }

      // Insertion sort
      for (int i = 1; i < str; i++) {
         String key = arr[i];
         int j = i - 1;
         while (j >= 0 && arr[j].compareTo(key) > 0) {
            arr[j + 1] = arr[j];
            j = j - 1;
         }
         arr[j + 1] = key;
      }

      System.out.println("\nSorted String using Insertion sort: ");
      for (int i = 0; i < str; i++) {
         System.out.print("[" + arr[i] + "] ");
      }
      read.close();
   }
}