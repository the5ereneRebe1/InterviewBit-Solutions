package Problems;
import java.util.Arrays;

public class LuckyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LuckyNumber rs= new LuckyNumber();
		System.out.println(rs.solve(40));
	}
	public int solve(int A) {
        boolean prime[] = new boolean[A+1];
        for(int i=0;i<=A;i++)
        	prime[i]=true;
        int count[] = new int[A+1];
        int finalcount=0;
        for(int j=2;j<=A/2;j++){
            if(prime[j])
                for(int k=2;k*j<=A;k++){
                	prime[j*k]=false;
                    count[j*k]+=1;
                }
            System.out.println(Arrays.toString(count));
        }
        for(int i:count)
        	if(i==2) finalcount+=1;
        return finalcount;
    }

}
