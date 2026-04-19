package Heap;

public class HeapSort {

    public static void heapify(int arr[], int i, int size) {

        int left = 2*i + 1;
        int right = 2*i + 2;
        int max = i;

        if(left < size && arr[left] > arr[max]) {
            max = left;
        }

        if(right < size && arr[right] > arr[max]) {
            max = right;
        }

        if(max != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            heapify(arr, max, size);
        }
    }

    public static void heapSort(int arr[]) {

        int n = arr.length;

        // Step 1: Build Max Heap
        for(int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // Step 2: Push largest to end
        for(int i = n-1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 4, 5, 3};

        heapSort(arr);

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}