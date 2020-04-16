package Problems;

public class AllocateBooks {

	public static void main(String[] args) {
		AllocateBooks ab  = new AllocateBooks();
		int A[] = {73, 58, 30, 72, 44, 78, 23, 9};
		System.out.println(ab.books(A, 5));
	}
	public int books(int[] A, int B) {
        int min = Integer.MIN_VALUE,max = 0;
        int ans = -1;
        for(int i=0;i<A.length;i++){
            max +=A[i];
            min = Math.max(min,A[i]);
        }
       
        while(min<=max){
            int mid = min+(max-min)/2;
            if(checkFeasablity(A,B,mid)){
                ans = mid;
                max = mid-1;
            }
            else 
                min = mid+1;
        }
        return ans;
    }
	private boolean checkFeasablity(int[] A,int B,int mid){
        int buffer = 0,i=0;
        int studentsReqd = 1;
        for(i=0;i<A.length;i++){
            if(A[i]> mid) return false;
            if(A[i]+buffer>mid){
                studentsReqd ++;
                buffer = A[i];
                
            }
            else{
                buffer+=A[i];
            }
            if(studentsReqd>B)
                return false;
        }
        System.out.println(mid+":"+studentsReqd);
        if(studentsReqd<B)
        	return false;
        
        return true;
    }
   

}
