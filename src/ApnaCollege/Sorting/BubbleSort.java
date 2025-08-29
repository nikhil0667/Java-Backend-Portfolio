package ApnaCollege.Sorting;


public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 9, 1, 84, 15, 35, 565};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int a : arr) {
            System.out.print(a+" ");
        }
    }

}
