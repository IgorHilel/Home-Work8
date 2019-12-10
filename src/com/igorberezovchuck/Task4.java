package com.igorberezovchuck;

import java.util.Arrays;
import java.util.Random;

public class Task4 {

    private static final int MAX_COUNT = 10000;

    public static void main(String[] args) {

        int[] array1 = getArray();
        long time = System.currentTimeMillis();
        bubbleSort(array1);
        time = System.currentTimeMillis() - time;
        System.out.println(Arrays.toString(array1));
        System.out.println("Bubble sort time: " + time / 1000.0);

        int[] array2 = getArray();
        time = System.currentTimeMillis();
        selectionSort(array2);
        time = System.currentTimeMillis() - time;
        System.out.println(Arrays.toString(array2));
        System.out.println("Selection sort time: " + time / 1000.0);

        int[] array3 = getArray();
        time = System.currentTimeMillis();
        insertSort(array3);
        time = System.currentTimeMillis() - time;
        System.out.println(Arrays.toString(array3));
        System.out.println("Insert sort time: " + time / 1000.0);

    }

    private static void insertSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
    }

    private static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static int[] getArray () {
        int[] arr = new int[MAX_COUNT];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
