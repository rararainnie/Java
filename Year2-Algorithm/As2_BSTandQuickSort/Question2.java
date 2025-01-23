/*
 * 65050389 Thumasorn Prasertsri
 * Assignment 2
 * data = 12, 39, 32, 75, 16, 45, 39, 86, 23, 38
*/

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = userInput.nextInt();

        int[] data = new int[n];

        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            data[i] = userInput.nextInt();
        }

        quickSort(data, 0, n - 1);

        System.out.print("\nSorted Data: ");
        for (int value : data) {
            System.out.print(value + " ");
        }

        userInput.close();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
