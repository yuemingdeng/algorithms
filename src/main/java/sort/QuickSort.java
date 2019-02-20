package sort;

public class QuickSort {

    public static void main(String[] args) {
        int [] a = {5,1,4,6,4,6,10,9,8};
    }

    public static void quickSort(int [] array, int left, int right) {
        /*int i,j;
        if(left < right) {
            i = left;
            j = right;
            do {
                do i ++; while(array[i] array[]);
                if(array[i] > array[j]) {
                    swap(array,i,j );
                }
            }while(i < j);

        }
*/

    }

    public static int[] swap(int [] array, int i ,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return  array;
    }
}
