package Problems;

public class RepeatSubtraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatSubtraction rs= new RepeatSubtraction();
		rs.getFinal(15, 5);
	}
	public int getFinal(int A, int B) {
        System.out.print(A+","+B+";");
        if(A==B) return A+B;
        if(A<=0) return B;
        if(B<=0) return A;
        if(A>B) return getFinal(A-B,B);
        else if(B>A) return getFinal(A,B-A);
        return -1;
    }

}
