package Problems;

public class BinaryExponent {

	public static void main(String[] args) {
		BinaryExponent bExponent = new BinaryExponent();
		System.out.println(bExponent.binExpo(0,0));
	}
	
	public int binExpo(int num,int pow) {
		//Initial case
		if(pow==0 && num == 0) return Integer.MIN_VALUE;
		if(pow == 0) return 1;
		//Recursive call
		int ans = binExpo(num, pow/2);
		if(pow%2==0)
			return ans*ans;
		else
			return ans*ans*num;
	}

}
