package search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;

public class FindThree {
    public static void main(String[] args) {
        int[] arr = { 2, 1, -1, -9, 10, 8, 7 };
        System.out.println(process(arr));
    }

    private static String process(int[] keys) {
        Arrays.sort(keys);
        print(keys);
        HashSet<Vector<Integer>> set = new HashSet<Vector<Integer>>();
        for (int i = 0; i < keys.length; i++) {
            int a = keys[i];
            int j = i + 1;
            int k = keys.length - 1;
            while (j < k) {
                int sum = a + keys[j] + keys[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    Vector<Integer> vector = new Vector<Integer>(3);
                    vector.add(a);
                    vector.add(keys[j]);
                    vector.add(keys[k]);
                    set.add(vector);
                    j++;
                    k--;
                }
            }
        }
        return set.toString();

    }

    private static void print(int[] keys) {
        for (int key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();
    }

}

