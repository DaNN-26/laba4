import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];
        for(int i = 0; i < array.length; i++)
        {
            System.out.printf("Введите %d число массива:", i + 1);
            array[i] = input.nextInt();
        }
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(array));
        HeapSort hs = new HeapSort();
        hs.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length - 4;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}