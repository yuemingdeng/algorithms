package sort;


/**
 * 冒泡排序
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] a = {5,1,4,6,4,6,10,9,8};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }
    
    public static int[] bubbleSort(int[] array) {
        if(array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i <= array.length -1; i++) {
            for (int j = 0; j <= array.length - i - 2; j++) {
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
