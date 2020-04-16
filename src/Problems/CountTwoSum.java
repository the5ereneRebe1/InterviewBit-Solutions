package Problems;

/**
 * CountTwoSum
 */
public class CountTwoSum {

    public static void main(String[] args) {
        System.out.println(new CountTwoSum().solve(new int[]{1, 2, 6, 6, 7, 9, 9 }, 13));
    }
    
    public int solve(int[] A, int B) {
        int i=0,j=1,count=0;
        while(i<j){
        
        if(A[i]+A[j]<B && j<A.length-1)
            j++;
        else if(A[i]+A[j]==B){
            count++;
            i++;
        }
        else
            i++;
        System.out.println(i+":"+j+" = "+(A[i]+A[j]));
        }
        return count;
    }
}