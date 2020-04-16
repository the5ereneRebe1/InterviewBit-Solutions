package Problems;

import java.util.HashSet;

public class SquareRoot {

	public static void main(String[] args) {
		SquareRoot sRoot = new SquareRoot();
		System.out.println(sRoot.sqrt(2147483647));
	}
	 public int sqrt(int A) {
	        int min  = 1;
	        int max = A;
	        int ans=0;
	 
	        while(min<=max){
	            int mid = min+(max-min)/2;
	            long temp = (long)mid*mid;
	            if(temp>A)
	                max = mid-1;
	            else if(temp<A){
	                ans = mid;
	                System.out.println(ans);
	                min = mid+1;
	            }
	            else if(temp==A)
	                return mid;
	            
	        }
	        return ans;
	    }
}
