import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class BAGSIC_OE3 {
    public static void main(String[] args) throws Exception {
        LinkedList<String> words = new LinkedList<>();
        String input;

        Scanner scanner = new Scanner(System.in);

        do {
            int menuOption;

            System.out.print("\033[H\033[2J");

            System.out.println("1. Enter the 5 Initial Elements for the Linked List");
            System.out.println("2. Add Node at the beginning of the Linked List");
            System.out.println("3. Add Node at the end of the Linked List");
            System.out.println("4. Add Node after the specified Node in the Linked List");
            System.out.println("5. Exit Program");

            System.out.print("\nSelect : ");
            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1: {
                    System.out.println("Enter 5 words to be stored in the Linked List");

                    for (int i = 0; i < 5; i++) {
                        input = scanner.next();
                        words.add(input);
                    }

                    System.out.println("\n" + words);

                    promptAndWait(scanner);

                    break;
                }

                case 2: {
                    String firstWord;

                    System.out.println("Enter a word to be added to the beginning of the Linked List");
                    firstWord = scanner.next();

                    words.addFirst(firstWord);
                    System.out.println("\n" + words);

                    promptAndWait(scanner);

                    break;

                }

                case 3: {
                    String lastWord;

                    System.out.println("Enter a word to be added to the end of the Linked List");
                    lastWord = scanner.next();

                    words.addLast(lastWord);

                    System.out.println("\n" + words);

                    promptAndWait(scanner);

                    break;
                }

                case 4: {
                    String specificWord;
                    String specificNode;

                    System.out.println("Enter a word to be added after the specified Node in the Linked List");
                    specificWord = scanner.next();

                    System.out.println("\n" + words);

                    System.out.println("Enter the specific word in the Linked List: ");
                    specificNode = scanner.next();

                    int nodeIndex = words.indexOf(specificNode);

                    words.add(nodeIndex + 1, specificWord);

                    System.out.println("\n" + words);

                    promptAndWait(scanner);

                    break;

                }

                case 5: {
                    System.exit(0);
                    break;
                }
            }
        } while (true);
    }

    public static void promptAndWait(Scanner scanner) {
        System.out.print("\nPress any key to continue");
        scanner.nextLine();
    }
}