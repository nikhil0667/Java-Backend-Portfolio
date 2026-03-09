package ApnaCollege.Sorting;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {12, 42, 75, 8, 5, 3, 869709, 807, 43635, 46, 6, 487};
        int[] ar = bubbleSort(arr);
        for (int a : ar) {
            System.out.print(a + " ");
        }
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
