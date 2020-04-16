package Problems;
import java.util.Scanner;

public class MaxValidString {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String A = s.nextLine();
		int B = s.nextInt();
		int len = A.length();
		int max = Integer.MIN_VALUE;
		int bCount = 0,left=0,right=0;
		while(right<len) {
			if(A.charAt(right)=='b')
				bCount++;
			if(bCount>B) {
				while(bCount>B) {
					if(A.charAt(left)=='b')
						bCount--;
					left++;
				}
			}
			right++;
			max = Math.max(max,right-left);
		}
		System.out.println(max);
		s.close();
	}

}
