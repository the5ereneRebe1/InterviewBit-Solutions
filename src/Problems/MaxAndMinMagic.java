package Problems;

import java.util.Arrays;

public class MaxAndMinMagic {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxAndMinMagic().solve(new int[]{3,-1,11,5})));
    }
    //-1 3 5 11 
    public int[] solve(int[] A) {
        Arrays.sort(A);
        int ans[] = new int[2];
        for(int i=0,j=A.length/2;i<A.length/2;i++,j++){
            ans[0]+=Math.abs(A[i]-A[j]);
        }
        for(int i=0;i<A.length-1;i+=2){
            System.out.println(i+":"+ans[1]);
            ans[1]+=Math.abs(A[i]-A[i+1]);
        }
        return ans;
    }
}