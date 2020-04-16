package Problems;
import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubset {

	public static void main(String[] args) {
		AllPossibleSubset aSubset = new AllPossibleSubset();
		int input[] = {1,2,3};
		aSubset.subset(input,0,new ArrayList<Integer>());
	}
	
	public void subset(int A[],int i,List<Integer> aux) {
		//Base Case
		if(i==A.length) {
			System.out.println(aux.toString());
			return;
		}
		//Don't Take
		subset(A,i+1,new ArrayList<Integer>(aux));
		//Take
		aux.add(A[i]);
		subset(A, i+1,new ArrayList<Integer>(aux));
	}

}
