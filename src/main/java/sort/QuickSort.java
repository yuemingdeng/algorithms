package sort;


public class QuickSort {

    public static void main(String[] args) {
        int[] a = {72,68};
        quickSort(a, 0, 1);
        for (int i : a) {
            System.out.println(i);
        }
    }


    public static int[] quickSort(int[] a, int left, int right) {
            System.out.println(left + "--------------------" + right);
        int i, j;
        if (left < right) {
            i = left;
            j = right + 1;
            do {
                do i++; while (a[i] < a[left]);
                do j--; while (a[j] > a[left]);
                if (i < j) swap(a, i, j);
            } while (i < j);
            swap(a, left, j);
            quickSort(a, left, j - 1);
            quickSort(a, j + 1, right);
        }
        return a;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
