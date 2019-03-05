package sort;

import java.util.Arrays;

/**
 * 将两个有序数组合并成一个有序数组，并去除数组中重复元素
 */
public class SortTwoSortedArray {

    public static void main(String[] args) {
        int[] a = {12, 32, 63, 84, 105};
        int[] b = {12, 32, 53, 74, 95};
        int [] result = getSortTwoSortedArray(a,b);
        for(int num : result) {
            System.out.println(num);
        }


    }

    public static int[] getSortTwoSortedArray(int [] a, int [] b) {
        int i =0, j = 0, k = 0;
        int e =0;
        int [] resultArray = new int [a.length + b.length];
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                resultArray[k++] = a[i++];
            }else if(a[i] > b[j]) {
                resultArray[k++] = b[j++];
            } else {
                resultArray[k++] = a[i++];
                j++;
                e++;
            }
        }

        while (i < a.length) {
            resultArray[k++] = a[i++];
        }

        while(j < b.length) {
            resultArray[k++] = b[j++];
        }

        //去除重复元素导致的数组大小冗余
        resultArray = Arrays.copyOf(resultArray, resultArray.length -e);
        return resultArray;

    }
}
