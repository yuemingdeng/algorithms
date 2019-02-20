package sort;


/**
 * 冒泡排序
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] a = {5,1,4,6,4,6,10,9,8};
        bubbleSort(a);
        for(int ss : a) {
            System.out.println(ss);
        }

    }


    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
