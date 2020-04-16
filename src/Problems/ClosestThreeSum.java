package Problems;

import java.util.Arrays;

public class ClosestThreeSum {
    public static void main(String[] args) {
        System.out.println(new ClosestThreeSum().threeSumClosest(new int[]{2, 1, -9, -7, -8, 2, -8, 2, 3, -8}, -1));
    }
    public int threeSumClosest(int[] A, int B) {
        int closest = Integer.MIN_VALUE;
        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            int sum = B-A[i];
            int start = i+1,end = A.length-1;
            while(start<end){
                if(A[start]+A[end]==sum){
                    return B;
                }
                if(A[start]+A[end]>sum){
                    closest = Math.abs(B-(A[start]+A[end]+B-sum))<(B-closest)?(A[start]+A[end]+B-sum):closest;
                    System.out.println(closest+"+");
                    end--;
                }else{
                    closest = Math.abs(B-(A[start]+A[end]+B-sum))<(B-closest)?(A[start]+A[end]+B-sum):closest;
                    System.out.println(closest+"-");
                    start++;
                }
            }
        }
        return closest;
    }
}