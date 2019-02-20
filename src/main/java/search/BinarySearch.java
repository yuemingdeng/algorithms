package search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 7, 9, 10, 15};
        System.out.println(binarySearch(a, 15));
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            System.out.println(mid);
            if (key == array[mid]) {
                return mid;
            } else {
                if (key < mid) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;

    }
}
