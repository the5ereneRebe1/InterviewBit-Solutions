package Problems;

import java.util.Arrays;

public class AggresiveCows {

	public static void main(String[] args) {
		AggresiveCows ab  = new AggresiveCows();
		int A[] = {82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95};
		System.out.println(ab.solve(A, 8));
	}

public int solve(int[] A, int B) {
	Arrays.sort(A);
    int min =Integer.MAX_VALUE,max=Integer.MIN_VALUE;
    for(int i=0;i<A.length;i++){
        min = Math.min(min,A[i]);
        max = Math.max(max,A[i]);
    }
    max -=min;
    min  = 1;
    int ans =-1;
    System.out.println(min+":"+max);
    while(min<=max){
        int mid = min+(max-min)/2;
        System.out.println(mid);
        if(isFeasable(A,B,mid)){
            ans = Math.max(ans,mid);
            min = mid+1;
        }
        else
            max = mid-1;
    }
    return ans;
}
private boolean isFeasable(int[] A,int B,int mid){
    int cowsReqd = 1;
    int lastPos = A[0];
    for(int i=1;i<A.length;i++){
        if((A[i]-lastPos)>=mid) {
        	
            cowsReqd++;
            System.out.println(mid+":"+i+":"+cowsReqd);
            if(cowsReqd>=B)
                return true;
            lastPos = A[i];
        }
    }
    return false;
}
}