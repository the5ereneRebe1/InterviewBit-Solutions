package Problems;

public class FindInSortedMatrix {

	public static void main(String[] args) {
		int A[][] = {
					{2,3,4,6},
					{16,19,33,36},
					{37,38,38,41},
					{47,47,50,51},
					{55,57,58,62},
					{63,65,66,66},
					{68,70,75,77},
					{78,84,84,86},
					{86,87,88,92},
					{94,95,96,97}
					};
		int B=84;
		FindInSortedMatrix fMatrix = new FindInSortedMatrix();
		System.out.println("Executing...");
		System.out.println(fMatrix.searchMatrix(A, B));
	}
	
	public int searchMatrix(int[][] A, int B) {
        for(int i=0;i<A.length;i++){
            if(A[i][0]<=B && A[i][A[i].length-1]>=B){
            	System.out.println(i);
            	int start=0,end=A[i].length-1,mid=0;
            	while(start<=end){
            		mid = start+(end-start)/2;
            		if(A[i][mid] == B) return 1;
            		if(A[i][mid]<B)
            			start=mid+1;
            		else if(A[i][mid]>B)
            			end= mid-1;
            	}
            } else 
            	continue;
        }
        return 0;
    }

}
