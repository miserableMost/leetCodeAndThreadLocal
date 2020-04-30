package DataStructures.sort;

public class TestSort {
    public static void main(String[] args) {
       int[] arr = {23,13,2,34,12,24};
       sort2(arr);

    }
    public static void sort2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int num = a[i];
            int j;
            for (j = i; j > 0 && num < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = num;
        }
    }

}
