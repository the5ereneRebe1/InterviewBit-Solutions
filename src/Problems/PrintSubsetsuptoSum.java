package Problems;
import java.util.ArrayList;
import java.util.List;

public class PrintSubsetsuptoSum {

	public static void main(String[] args) {
		PrintSubsetsuptoSum aSubset = new PrintSubsetsuptoSum();
		int input[] = {5,4,1};
		System.out.println(aSubset.subset(input,0,0,10,new ArrayList<Integer>()));
	}
	
	public int subset(int A[],int i,int sum,int target,List<Integer> aux) {
		//Base Case
		
		if(i==A.length) {
			if(sum==target) {
				System.out.println(aux.toString());
				return 1;
			}
			return 0;
		}
		//Don't Take
		aux.add(A[i]);
		int take=subset(A,i+1,sum+A[i],target,new ArrayList<Integer>(aux));
		//Take
		aux.remove(aux.size()-1);
		int dontTake=subset(A, i+1,sum,target,new ArrayList<Integer>(aux));
		return take+dontTake;
	}

}
