package Problems;

public class CountSubsetuptoSumRep {
	
	public static void main(String[] args) {
		
		CountSubsetuptoSumRep aSubset = new CountSubsetuptoSumRep();
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
		
		if(sum>target)
				return 0;
		//Take/Repeat
		int take=subset(A,i,sum+A[i],target);
		//Don't Take/Continue
		int dontTake=subset(A, i+1,sum,target);
		return take+dontTake;
	}

}
