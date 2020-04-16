package Problems;

import java.util.Arrays;

/**
 * ArrangeZeroAndOne
 */
public class ArrangeZeroAndOne {

    public static void main(String[] args) {
        System.out.println(new ArrangeZeroAndOne().solve("1110101"));
        System.out.println(findSwaps(new int[]{1,1,1,0,1,0,1}));
    }
    public int solve(final String A) {
        int a[] = new int[A.length()];
        int n = A.length();
        for(int i=0;i<n;i++){
            a[i] = Character.getNumericValue(A.charAt(i));
        }
        System.out.println(Arrays.toString(a));
        int count = 0;
        int[] zeroes = new int[n];
        int[] t = new int[n];
        int c = 0;
        zeroes[n-1] = 1 - a[n-1];
        t[0] = 1 + a[0];
        for (int i=1; i<n; i++){
            t[i] = t[i-1];
            if (a[i] == 0) t[i] ++;
        }
        for (int i=n-2; i>=0; i--){
            zeroes[i] = zeroes[i+1];
            if (a[i] == 0) zeroes[i]++;
        }
        for (int i=0; i<n; i++){
            if (a[i] == 1){
                count += zeroes[i];
                c += t[i];
            }
        }
        return Math.min(count, c); 
    }
    private static int findSwaps(int[] a){
        int n = a.length, count = 0;
        int[] zeroes = new int[n];
        int[] t = new int[n];
        int c = 0;
        zeroes[n-1] = 1 - a[n-1];
        t[0] = 1 + a[0];
        for (int i=1; i<n; i++){
            t[i] = t[i-1];
            if (a[i] == 0) t[i] ++;
        }
        for (int i=n-2; i>=0; i--){
            zeroes[i] = zeroes[i+1];
            if (a[i] == 0) zeroes[i]++;
        }
        for (int i=0; i<n; i++){
            if (a[i] == 1){
                count += zeroes[i];
                c += t[i];
            }
        }
        return Math.min(count, c);
    }
}