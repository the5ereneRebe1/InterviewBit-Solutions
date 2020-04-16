package Problems;

public class MatrixMedian {

	public static void main(String[] args) {
		int[][] A = {{1,3,5},{2,6,8},{1,6,8}};
		MatrixMedian mmMedian = new MatrixMedian();
		System.out.println(mmMedian.findMedian(A));
	}
	public int findMedian(int[][] A) {
		int n = A.length,m=A[0].length;
		int count = (n*m)/2;
		int minMed = A[0][0],maxMed = A[n-1][m-1];
		while(minMed<=maxMed) {
			int mid = minMed+(maxMed-minMed)/2;
			int k = countSmaller(A, mid);
			
			if(Math.abs(k)==count) {
				if(k<0)
					minMed=mid+1;
				else
					return mid;
			}
			else if(k<count)
				minMed = mid+1;
			else 
				maxMed=mid-1;
		}
		
		return -1;
		
	}
	public int countSmaller(int[][] A,int B) {
		int count=0;
		boolean found = false;
		int n = A.length,m=A[0].length;
		int counts = (n*m)/2;
		for(int i=0;i<A.length;i++) {
			int start = 0,end = A[i].length-1,pos=-1;
			while(start<=end) {
				int mid = start+(end-start)/2;
				if(A[i][mid]==B) {
					found=true;
					//System.out.println(B+" found");
					pos=mid-1;
					break;
				}
				if(A[i][mid]<B) {
					pos = mid;
					start=mid+1;
				}
				else if(A[i][mid]>B)
					end = mid-1;
			}
			System.out.println(B+","+i+":"+(pos+1)+":"+found);
			count+=pos+1;
		
		}
		
		return (found==false && count==counts)?-count:count;
	}

}
