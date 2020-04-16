package Problems;
import java.util.Scanner;

public class BalanceBrackets {

	public static void main(String[] args) {
		int lr[] = new int[2];
		Scanner s = new Scanner(System.in);
		String bracket = s.nextLine();
		for(char c:bracket.toCharArray()) {
			if(c=='(') {
					lr[1]++;
			}else {
				if(lr[1]!=0)
					lr[1]--;
				else
					lr[0]++;
			}
			System.out.println(lr[0]+","+lr[1]);
		}
		
		
		s.close();
	}

}
