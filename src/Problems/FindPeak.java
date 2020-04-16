package Problems;

public class FindPeak {

	public static void main(String[] args) {
		int A[] = {1, 2, 3, 4, 2};
		FindPeak fPeak = new FindPeak();
		System.out.println(fPeak.solve(A));
	}
	public int solve(int[] A) {
        int start =0,end=A.length-1,mid=0;
        while(start<=end){
            mid = start +(end-start)/2;
            if(
                    (mid-1<0 && A[mid]>=A[mid+1]) || 
                    (mid+1>=A.length && A[mid]>=A[mid-1]) ||
                    (A[mid]>=A[mid-1] && A[mid]>=A[mid+1])
                )
                    return A[mid];
            if(mid+1<A.length && A[mid+1]>A[mid]) {
            	start=mid+1;
            }else if(mid-1>0 && A[mid-1]>A[mid]) {
            	end=mid-1;
            }
        }
        return -1;
    }

}
