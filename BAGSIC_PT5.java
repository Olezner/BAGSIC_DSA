import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// Binary Tree class
class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    // Method to insert a new node into the binary tree
    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Method to perform in-order traversal of the binary tree
    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    // Method to perform pre-order traversal of the binary tree
    void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // Method to perform post-order traversal of the binary tree
    void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }
}

// Main class
public class BAGSIC_PT5 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        // Get user input for array of integers
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            binaryTree.insert(arr[i]);
        }

        // Menu selection for traversal options
        System.out.println("[1] In-order Traversal");
        System.out.println("[2] Pre-order Traversal");
        System.out.println("[3] Post-order Traversal");

        // Get user input for menu selection
        System.out.print("Select option: ");
        int option = scanner.nextInt();

        // Perform the selected traversal based on user input
        switch (option) {
            case 1:
                System.out.print("In-order Traversal: ");
                binaryTree.inOrderTraversal(binaryTree.root);
                break;
            case 2:
                System.out.print("Pre-order Traversal: ");
                binaryTree.preOrderTraversal(binaryTree.root);
                break;
            case 3:
                System.out.print("Post-order Traversal: ");
                binaryTree.postOrderTraversal(binaryTree.root);
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}