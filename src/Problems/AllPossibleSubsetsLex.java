package Problems;
import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubsetsLex {
	public static void main(String[] args) {
		AllPossibleSubsetsLex aSubset = new AllPossibleSubsetsLex();
		int input[] = {1,2,3};
		aSubset.subset(input,0,new ArrayList<Integer>(),true);
	}
	
	public void subset(int A[],int i,List<Integer> aux,boolean branch) {
		if(branch)System.out.println(aux.toString());
		//Base Case
		if(i==A.length) {
		
			return;
		}
		//Don't Take
		aux.add(A[i]);
		subset(A,i+1,new ArrayList<Integer>(aux),true);
		//Take
		aux.remove(aux.size()-1);
		subset(A, i+1,new ArrayList<Integer>(aux),false);
	}


}
