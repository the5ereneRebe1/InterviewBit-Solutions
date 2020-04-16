package Problems;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberAll {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static void main(String[] args) {
        int A[] = {3, 30, 34, 5, 9};
        System.out.println(new LargestNumberAll().largestNumber(A));
    }
    public String largestNumber(final int[] A) {
        StringBuffer ans = new StringBuffer();
        String arr[] = new String[A.length];
        for(int i =0;i<A.length;i++){
            arr[i] = String.valueOf(A[i]); 
        }
        Comparator<String> compare = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num1 = Integer.parseInt(""+o1+o2);
                int num2 = Integer.parseInt(""+o2+o1);
                return num2-num1;
            }
        };
        Arrays.sort(arr,compare);
        for(String s:arr){
            ans.append(s);
        }
        return ans.charAt(0)=='0'?"0":ans.toString();
    }
    
}