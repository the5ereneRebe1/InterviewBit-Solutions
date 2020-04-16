package Problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PrimeFactors {

	public static void main(String[] args) {
		// TODO Generate prime factors out of numbers
		System.out.println(Arrays.toString(PrimeFactors.primefactors(151517)));
		
	}
	
	private static int[] primefactors(int num) {
		int primes[] = PrimeSeive.findPrimes((int) num/2);
//		System.out.println(Arrays.toString(primes));
		List<Integer> ans = new ArrayList<Integer>();
		int counter = 0;
		while(num!=1) {
//			System.out.println(counter+"/"+num+"/"+primes[counter]);
			if(num%primes[counter]==0) {
				num = num/primes[counter];
				ans.add(primes[counter]);
			}
			else
				counter++;
		}
		
		
		return ans.stream().mapToInt(i->i).toArray();
	}

}
