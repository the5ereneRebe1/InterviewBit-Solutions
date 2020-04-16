package Problems;

import java.util.ArrayList;

public class PermutationDistinct {
	ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

	public static void main(String[] args) {
		PermutationDistinct pdDistinct = new PermutationDistinct();
		ArrayList<Integer> q = new ArrayList<>();
		q.add(1);
		q.add(1);
		q.add(3);
		System.out.println(pdDistinct.permute(q));

	}
	
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        
        
        findPermutations(A,0);
        return answer;
    }
    private void findPermutations(ArrayList<Integer> A,int index){
    	
        if(index>=A.size()-1){
            answer.add(new ArrayList<Integer>(A));
            return;
        }
        for(int i=index;i<A.size();i++){
        	boolean check = shouldSwap(A,index,i);
            if(check){
        		System.out.println(index+":"+i);
                swap(A,index,i);
                findPermutations(A,index+1);
                swap(A,index,i);
            }
        }
    }
    private boolean shouldSwap(ArrayList<Integer> A,int index,int curr){
        for(int i=index;i<curr;i++)
            if(A.get(i)==A.get(curr))
                return false;
        return true;
        }
    private void swap(ArrayList<Integer> A,int i,int j){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }


}

