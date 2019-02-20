package search;

import java.util.*;

public class TreeeZero {


    public static void main(String[] args) {
        Integer[] arr = {2, 1, -1, -9, 10, 8, 7};
        getList(arr);

    }

    public static Set<List<Integer>> getList(Integer[] array) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(array);
        List<Integer> listA = Arrays.asList(array);
        System.out.println(listA);
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            int j = i + 1;
            int k = array.length - 1;
            while(j < k) {
                int sum = a +array[j] + array[k] ;
                if(sum < 0) {
                    j ++;
                } else if (sum > 0) {
                    k --;
                } else {
                    List<Integer> list1 = new ArrayList<Integer>();
                    list1.add(a);
                    list1.add(array[j]);
                    list1.add(array[k]);
                    set.add(list1);
                    j ++;
                    k --;
                }
            }

        }
        System.out.println(set);
            return set;
    }
}
