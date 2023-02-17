import java.util.Scanner;

public class BAGSIC_PT1{
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        System.out.println("Choose a condition");
        System.out.println("1. Stack");
        System.out.println("2. Queue");

        String menu = scan.nextLine();
        switch(menu)
        {
            case "1":
            Stack();
            break;
            
            case "2":
            Queue();
            break;
        }
    }

    static void Stack()
    {
        Scanner scan = new Scanner(System.in);

        int [] num = new int[100];
        int top = -1;

        System.out.print("Enter the number of elements to add into the stacks: ");
        int maxnum = scan.nextInt();

        System.out.println("Enter the elements to add into the stack: ");
        for (int i = 0; i < maxnum; i++)
        {
            int array = scan.nextInt();
            push(num, array, top);
            top++;

            System.out.println("Stack after push: ");
            stckprnt(num,top);
        }

        System.out.println("The element at the top is ["+ num[top]+"]");
        
        System.out.println("The number of pop operations to perform in the stack: ");
        int popnum = scan.nextInt();

        System.out.println("New stack after pop operation: ");
        for (int i = 0; i < popnum; i++)
        {
            pop(num, top);
            top--;
            System.out.println("Stack after pop");
            stckprnt(num, top);
        }

        System.out.println("The top element is " + num[top]);

    }

    static void Queue()
    {
        Scanner scan = new Scanner(System.in);

        int [] num = new int[100];

        int front = 0;
        int rear = -1;

        System.out.println("Enter the number of elements to add into the queue: ");
        int maxnum = scan.nextInt();

        System.out.println("Enter the elements to add into the queue");
        for(int i = 0; i < maxnum; i++)
        {
            int array = scan.nextInt();
            rear ++;
            equeue(num, array, rear);
            
            System.out.println("queue after enqueue: ");
            prntqueue(num, front, rear);
        }

        System.out.println("The front element is ["+ num[front]+"]");
        System.out.println("The back element is ["+ num[rear]+"]");

        System.out.println("Number of dequeue operations to perform into the queue: ");
        int popnum = scan.nextInt();

        System.out.println("Queue after each dequeue operations: ");
        for (int i = 0; i < popnum; i++)
        {
            dqueue(num, front);
            front++;

            System.out.println("Queue after dequeue: ");
            prntqueue(num, front, rear);
        }
        System.out.println("The front element is ["+ num[front]+"]");
        System.out.println("The front element is ["+ num[rear]+"]");
    }
    
    public static void push(int [] num, int array, int top)
    {
        num[top + 1] = array;    
    }

    public static void pop(int [] num, int top)
    {
        num[top] = 0;
    }

    public static void stckprnt(int[] num, int top)
    {
        for(int i = top; i >= 0; i--)
        {
            System.out.println("[" + num[i] + "]");
        }    
    }

    public static void equeue(int [] num, int array, int rear)
    {
        num[rear] = array; 
    }

    public static void dqueue(int[] num, int front)
    {
        num[front] = 0;
    }

    public static void prntqueue(int[] num, int front, int rear)
    {
        for(int i = front; i <= rear; i++)
        {
            System.out.println("[" + num[i] + "] ");
        }   
    }
}