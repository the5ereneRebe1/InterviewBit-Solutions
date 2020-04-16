package Problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSeive {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(PrimeSeive.findPrimes(6)));
	}
	
	static public int[] findPrimes(int range) {
		boolean prime[] = new boolean[range+1];
		List<Integer> ans = new ArrayList<Integer>(); 
		for(int i = 2;i*i<=range;i++) {
			for(int j = 2;i*j<=range;j+=1) {
				prime[i*j] = true;
			}
		}
		for(int k = 2;k<=range;k++) {
			if(!prime[k]) ans.add(k);
		}
		return ans.stream().mapToInt(i->i).toArray();
	}
}
