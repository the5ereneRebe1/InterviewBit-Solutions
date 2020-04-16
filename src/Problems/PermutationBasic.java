package Problems;

import java.util.ArrayList;

public class PermutationBasic {
	ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

	public static void main(String[] args) {
		PermutationBasic pdDistinct = new PermutationBasic();
		ArrayList<Integer> q = new ArrayList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(pdDistinct.permute(q));

	}
	
public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        if(A.size()==1){
            ArrayList<ArrayList<Integer>> h1 = new ArrayList<>();
            h1.add(A);
            
            return h1;
        }
            
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            int start = A.get(i);
            A.remove(i);
            
            ArrayList<ArrayList<Integer>> perms = permute(A);
            
            for(ArrayList<Integer> perm : perms){
                perm.add(0,start);
                temp.add(perm);
            }
            A.add(i,start);
        }
        return temp;
    }
}

