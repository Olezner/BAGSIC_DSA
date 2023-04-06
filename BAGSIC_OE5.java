import java.io.PushbackInputStream;
import java.util.Scanner;

public class BAGSIC_OE5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of elements: ");
        int arrsize = sc.nextInt();
        
        int[] element = new int[arrsize];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < arrsize; i++)
        {
            element[i] = sc .nextInt();
        }
        
        QSort(element, 0, arrsize-1);

        System.out.print("Sorted Elements: ");
        for (int i = 0; i < arrsize; i++) {
        System.out.print(element[i] + " ");
        }
    }

    public static void QSort(int[] element, int L, int H)
    {
        if (L < H)
        {
            int CIndex = partition(element, L, H);
            QSort(element, L, CIndex - 1);
            QSort(element, CIndex + 1, H);
        }
    }
    

    public static int partition(int[] element, int L, int H) {
        int change = element[H];
        int i = L - 1;
        for (int k = L; k <= H - 1; k++)
        {
            if (element[k] < change)
            {
                i++;
                reciprocate(element, i, k);
            }
        }
        reciprocate(element, i + 1, H);
        return i + 1;
    }

        public static void reciprocate(int[] element, int i, int k) {
            int temp = element[i];
            element[i] = element[k];
            element[k] = temp;
            
        }

       
       

}