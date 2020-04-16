package Problems;

public class CountSubsetsuptoSum {

	public static void main(String[] args) {
		CountSubsetsuptoSum aSubset = new CountSubsetsuptoSum();
		int input[] = {5,4,1};
		System.out.println(aSubset.subset(input,0,0,10));
	}
	
	public int subset(int A[],int i,int sum,int target) {
		//Base Case
		
		if(i==A.length) {
			if(sum==target)
				return 1;
			return 0;
		}
		//Don't Take
		int take=subset(A,i+1,sum+A[i],target);
		//Take
		int dontTake=subset(A, i+1,sum,target);
		return take+dontTake;
	}

}
