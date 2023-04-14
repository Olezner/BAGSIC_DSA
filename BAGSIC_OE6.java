import java.util.*;

public class BAGSIC_OE6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[1] Manual Input");
        System.out.println("[2] Random Generator");

        int choice = scanner.nextInt();

        int[] arr;

        switch (choice) {
            case 1:
                arr = inputArrayFromUser(scanner);
                break;
            case 2:
                System.out.println("Enter the size of the array:");
                int size = scanner.nextInt();
                System.out.println("Enter the range of random values (minimum and maximum):");
                int min = scanner.nextInt();
                int max = scanner.nextInt();
                arr = generateRandomArray(size, min, max);
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                scanner.close();
                return;
        }

        System.out.println("Original Array: " + Arrays.toString(arr));

        hybridQuickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(arr));

        scanner.close();
    }

    public static void hybridQuickSort(int[] arr, int low, int high) {
        // Base case
        if (low < high) {
            // Use insertion sort for small subarrays
            if (high - low + 1 <= 10) {
                insertionSort(arr, low, high);
            } else {
                int pivotIndex = choosePivot(arr, low, high);
                int partitionIndex = partition(arr, low, high, pivotIndex);
                hybridQuickSort(arr, low, partitionIndex - 1);
                hybridQuickSort(arr, partitionIndex + 1, high);
            }
        }
    }

    public static int partition(int[] arr, int low, int high, int pivotIndex) {
        // Swap pivot with the last element
        swap(arr, pivotIndex, high);

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Swap pivot to its correct position
        swap(arr, i + 1, high);

        return i + 1;
    }

    public static int choosePivot(int[] arr, int low, int high) {
        // Choose pivot as the median of three elements: first, middle, and last
        int middle = low + (high - low) / 2;

        int first = arr[low];
        int middleElement = arr[middle];
        int last = arr[high];

        if ((first <= middleElement && middleElement <= last) || (last <= middleElement && middleElement <= first)) {
            return middle;
        } else if ((middleElement <= first && first <= last) || (last <= first && first <= middleElement)) {
            return low;
        } else {
            return high;
        }
    }

    public static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] inputArrayFromUser(Scanner scanner) {
        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max - min + 1) + min;
        }
        return arr;
    }
}