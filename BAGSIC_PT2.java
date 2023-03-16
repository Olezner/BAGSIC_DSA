import java. io.*;
import java.util.Scanner;

public class BAGSIC_PT2{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BAGSIC_PT2 list = new BAGSIC_PT2();
        int choice, position, n;

        do {
            System.out.println("\n[1] Create");
            System.out.println("[2] Delete");
            System.out.println("[3] Search");
            System.out.println("[4] Display");
            System.out.println("[5] Traverse");
            System.out.println("[6] Exit");
            System.out.println("Enter your choice:");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the number of elements:");
                    n = input.nextInt();
                    list.createList(n);
                    break;
                
                case 2:
                    System.out.println("Enter the position of the Element to delete:");
                    position = input.nextInt();
                    list.deleteNode(position);
                    break;

                case 3:
                    System.out.println("Enter the Element to search:");
                    n = input.nextInt();
                    list.search(n);
                    break;

                case 4:
                    list.displayList();
                    break;

                case 5:
                    System.out.println("Enter '1' for Forward or '2' For Backwards:");
                    choice = input.nextInt();
                    if (choice == 1) {
                    list.traverseForward();
                    } else if (choice == 2) {
                    list.traverseBackward();
                    } else {
                    System.out.println("Invalid option!");
                    }
                    break;
                    
            }

            
        } while (true);
        
    }

    class Node {
        int data;
        Node prev, next;
        Node(int d) { data = d; }
    }

    Node head, tail;

    public void createList(int n) {
        Scanner input = new Scanner(System.in);
        Node newNode;
        int data;

        if (n <= 0) {
            System.out.println("Invalid number of elements.");
            return;
        }

        head = tail = null;

        System.out.println("Enter data for element 1:");
        data = input.nextInt();
        head = new Node(data);
        tail = head;

        for (int i = 2; i <= n; i++) {
            System.out.println("Enter data for element " + i + ":");
            data = input.nextInt();
            newNode = new Node(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println("Doubly linked list created successfully.");
    }

    public void deleteNode(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Element deleted successfully.");
    }

    public void search(int value) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.data == value) {
                found = true;
                break;
            }
            current = current.next;
        }
        if (found) {
            System.out.println("Element found in the list.");
        } else {
            System.out.println("Element not found in the list.");
        }
    }
    
    private void traverseForward() {
            Node current = head;
            System.out.print("The doubly linked list in forward order is: ");
            while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
            }
            System.out.println();
        }
        
    private void traverseBackward() {
            Node current = tail;
            System.out.print("The doubly linked list in reverse order is: ");
            while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
            System.out.println();
        }
    
        public void displayList() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
    
            Node current = head;
    
            while (current != null) {
                System.out.print(current.data + " <-> ");
                current = current.next;
            }
            System.out.println("null");
        }
}

