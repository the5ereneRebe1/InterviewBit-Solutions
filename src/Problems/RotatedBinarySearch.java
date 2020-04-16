package Problems;
import java.util.Arrays;

public class RotatedBinarySearch {
	public static void main(String args[]) {
		int A[] = {12,14,18,21,3,6,8,9};
		RotatedBinarySearch rbs = new RotatedBinarySearch();
		System.out.println("Executing ...");
		System.out.println(rbs.binarySearch(A, 122));
		
	}
	public int binarySearch(int[] A,int key) {
		int start=0,end = A.length-1,mid=0;
		while(start<=end) {
			mid = start +(end-start)/2;
			printVisualization(A,start,end);
			if(A[mid]==key) return mid;
			if(A[mid]<=A[end]) {    //Mid lies in the right part
				if(key > A[mid] && key<=A[end]) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			}
			if(A[mid]>=A[start]) {  //Mid lies in the left part
				if(key < A[mid] && key>=A[start]) {
					end = mid -1;
				} else {
					start = mid+1;
				}
			}
		}
		
		return -1;
		
	}
	private void printVisualization(int[] A, int start, int end) {
		System.out.println(Arrays.toString(A));
		String[] B = new String[A.length];
		int mid = start+(end-start)/2;
		for(int i=0;i<B.length;i++) {
			if(i==mid || i==start || i==end)
				B[i]=" ^";
			else
				B[i]="  ";
		}
		System.out.println(Arrays.toString(B));
	}
}
