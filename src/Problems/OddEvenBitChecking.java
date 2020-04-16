package Problems;

public class OddEvenBitChecking {
	
	public static void main(String args[]) {
		System.out.println(isOdd(-11233));
	}
	static boolean isOdd(int num) {
		if((num&(1<<0))!=0)
			return true;
		return false;
	}

}
