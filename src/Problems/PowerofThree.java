package Problems;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerofThree {

	public static void main(String[] args) {
		PowerofThree pwThree = new PowerofThree();
		System.out.println(pwThree.solve(411));
	}
	public ArrayList<Integer> solve(int A) {
		ArrayList<Integer> pot = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		while(A!=0) {
			int rem = A%3;
//			if(A%3>1) {
//				ans.add(-1);
//				return ans;
//			}
			pot.add(rem);
			A=A/3;
		}
		System.out.println(pot);
		
		int j=0;
		for(int i:pot) {
			int pro = (int) (Math.pow(3, j));
			for(int k=0;k<i;k++)
				ans.add(pro);
			j++;
			}
			
		return ans;
        
    }

}
