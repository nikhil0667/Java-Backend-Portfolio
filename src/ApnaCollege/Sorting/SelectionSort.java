package ApnaCollege.Sorting;

public class SelectionSort {
    public static void printArray(int[] a) {
        for (int aa : a)
            System.out.print(
                    aa + " ");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 9, 1, 84, 15, 35, 565};
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
        printArray(arr);
    }
}
