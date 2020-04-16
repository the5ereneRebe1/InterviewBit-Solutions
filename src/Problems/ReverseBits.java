package Problems;

public class ReverseBits {
	public static void main(String args[]) {
		ReverseBits rb = new ReverseBits();
		System.out.println(rb.reverse(3));
	}
	public long reverse(long a) {
	    long ans=0;
	    for(int i=0;i<32;i++){
	        if((a&(1L << i)) != 0){
	            ans = ans|(1L<<(31-i));
	            System.out.println(i);
	        }
	    }
	    for(int j=0;j<64;j++) {
    		if((ans&(1L << j))>0)
    			System.out.print(1);
    		else System.out.print(0);
    	}
	    System.out.println();
	    return (long)ans;
	}
}
