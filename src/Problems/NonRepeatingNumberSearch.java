package Problems;

public class NonRepeatingNumberSearch {

	public static void main(String[] args) {
		NonRepeatingNumberSearch numberSearch = new NonRepeatingNumberSearch();
		int A[] = {1,1,2,2,3};
		System.out.println(numberSearch.solve(A));

	}
	public int solve(int[] A) {
        int start = 0,end = A.length-1,mid=0;
        while(start<=end){
            mid = start+(end-start)/2;
            //System.out.println(start+" ,"+end+" ,"+mid);
            if(
                    (mid-1<0 && A[mid]!=A[mid+1]) || 
                    (mid+1>=A.length && A[mid]!=A[mid-1]) ||
                    (A[mid]!=A[mid-1] && A[mid]!=A[mid+1])
                )
                    return A[mid];
            if(
                (mid-1>=0 && A[mid]==A[mid-1] && ((mid-1)%2==0)) || 
                (mid+1<A.length && A[mid]==A[mid+1] && (mid%2==0))
            )
            {
                //We are in the left part
                start=mid+1;
            } else {
                //We are in the right part
                end = mid-1;
            }
        }
        return -1;
    }

}
