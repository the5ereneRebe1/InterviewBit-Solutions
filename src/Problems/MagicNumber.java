package Problems;
public class MagicNumber {

	public static void main(String[] args) {
		MagicNumber mn = new MagicNumber();
		System.out.println(mn.solve(10));
	}
	
	public int solve(int A) {
        int ans=5;
        int mul = 5;
        for(int i=1;i<=A;i++){
            if(i%2!=0){
                mul*=5;
                ans=mul;
            }
            else 
                ans = mul+5;
            System.out.print(i+","+ans+"; ");
        }
        return ans;
    }
}
