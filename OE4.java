import java.io.*;
import java.util.Scanner;

public class OE4 {

    public static void main(String[] args) throws Exception {

        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(a);;

        do{
            int menu;
            System.out.print("\033[H\033[2J");

            System.out.println("[1] Fibonacci series number");
            System.out.println("[2] Factorial of a number");
            System.out.println("[3] Reverse a number");
            System.out.println("[4] Reverse a word");
            System.out.println("[5] Tower of Hanoi");
            System.out.println("[0] Exit the program");
            
            System.out.print("\n Select your choice: ");
            menu = Integer.parseInt(br.readLine());

        
            switch(menu) {
                case 1: {
                System.out.print("Enter the number of Fibonacci numbers to generate: ");
                    int n = Integer.parseInt(br.readLine());

                    System.out.print("Fibonacci Series of " + n + " numbers: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(fibonacci(i) + " ");
                    }

                    promptAndWait();
                    break;
                }
                
                
                case 2: {
                    System.out.print("Enter a number to find its factorial: ");
                    int number = Integer.parseInt(br.readLine());
                    Factorial(number);
                    promptAndWait();
                    break;
                }

                case 3: {
                    System.out.print("Enter a number to reverse: ");
                    int number = Integer.parseInt(br.readLine());
                    reverseNumber(number);
                    promptAndWait();
                    break;
                }

                case 4: {
                    System.out.print("Enter a word to reverse: ");
                    String word = br.readLine();
                    reverseWord(word);
                    promptAndWait();
                }

                case 5: {
                    System.out.print("Enter number of disks: ");
                    int numDisks = Integer.parseInt(br.readLine());
                    towerOfHanoi(numDisks, 'A', 'C', 'B');
                    promptAndWait();
                }

                case 0: {

                    System.exit(0);
                    break;
                }
            }

        } while (true);
    }

    public static int fibonacci(int n){
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void Factorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of "+number+" is "+factorial);
    }
    
    public static void reverseNumber(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        System.out.println("Reversed number is: "+ reversedNumber);
    }

    public static void reverseWord(String word) {
        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }
        System.out.println("Reversed word is: "+reversedWord);
    }
    
    public static void towerOfHanoi(int numDisks, char from, char to, char aux) {
        if (numDisks == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        towerOfHanoi(numDisks - 1, from, aux, to);
        System.out.println("Move disk " + numDisks + " from " + from + " to " + to);
        towerOfHanoi(numDisks - 1, aux, to, from);
    }

    public static void promptAndWait() throws Exception {
        InputStreamReader a = new InputStreamReader(System.in);
        BufferedReader ab = new BufferedReader(a);

        String key;

        System.out.print("\nPress any key to continue");
        key = ab.readLine();
    }
}
