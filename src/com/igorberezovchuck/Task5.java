package com.igorberezovchuck;

import java.util.Arrays;
import java.util.Random;

public class Task5 {

    private static final int MAX_COUNT = 10000;

    public static void main(String[] args) {

        int[] array1 = getArray();
        long time = System.currentTimeMillis();
        int low = 0;
        int high = array1.length - 1;
        quickSort(array1, low, high);
        System.out.println(Arrays.toString(array1));
        time = System.currentTimeMillis() - time;
        System.out.println("Quick sort time: " + time / 1000.0);

        int[] array2 = getArray();
        time = System.currentTimeMillis();
        heapSort(array2);
        System.out.println(Arrays.toString(array2));
        time = System.currentTimeMillis() - time;
        System.out.println("Heap sort time: " + time / 1000.0);

        int[] array3 = getArray();
        time = System.currentTimeMillis();
        sortMerge(array3, 0, (array3.length - 1));
        System.out.println(Arrays.toString(array3));
        time = System.currentTimeMillis() - time;
        System.out.println("merge sort time: " + time / 1000.0);

    }

    private static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int support = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < support) {
                i++;
            }
            while (array[j] > support) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }


    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sortMerge(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortMerge(arr, l, m);
            sortMerge(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static int[] getArray() {
        int[] arr = new int[MAX_COUNT];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
