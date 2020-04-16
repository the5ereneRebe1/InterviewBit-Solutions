package Problems;

import java.util.Arrays;

public class SpecialInteger {

	public static void main(String args[]) {
		SpecialInteger sInteger = new SpecialInteger();
		int A[] = {1,2,3,4,5};
		System.out.println(sInteger.solve(A, 10));
	}
	public int solve(int[] A, int B) {
        int n = A.length;
        int ans = -1;  
        int left = 1, right = n; 
        
        int prefixsum[] = new int[n + 1];
        Arrays.fill(prefixsum, 0); 
//        prefixsum[0]=A[0];  
        for (int i = 0; i < n; i++) 
            prefixsum[i + 1] = prefixsum[i] + A[i]; 
        System.out.println(Arrays.toString(prefixsum));
        while (left <= right)  
        { 
            int mid = (left + right) / 2; 
            int i; 
            for (i = mid; i < n+1; i++)  
            { 
                if (prefixsum[i] - prefixsum[i - mid] > B) 
                    break; 
            }
            if (i == n + 1) 
            { 
            	
                left = mid + 1; 
                ans = mid; 
            } 
            else
                right = mid - 1; 
        } 
  
        return ans; 
}
}
