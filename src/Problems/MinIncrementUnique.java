package Problems;

import java.util.Arrays;

public class MinIncrementUnique {
    public static void main(String[] args) {
        new MinIncrementUnique().minIncrementForUnique(new int[]{1,5,5,6,6,6,6});
    }
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0, need = 0;
        for (int a : A) {
            res += Math.max(need - a, 0);
            need = Math.max(a, need) + 1;
            System.out.println(a+":"+res+":"+need);
        }
        return res;
    }
}