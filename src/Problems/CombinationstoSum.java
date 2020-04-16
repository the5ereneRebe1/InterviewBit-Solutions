package Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;

public class CombinationstoSum {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        int temp[] = { 15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17 };
        for(int i:temp)
            a.add(i);
        System.out.println(new CombinationstoSum().combinationSum(a, 33));
    }
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> ans1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans2 = new ArrayList<>();
        Integer[] temp = a.toArray(new Integer[a.size()]);
        System.out.println(Arrays.toString(temp));
        backtrack(ans1,ans2,temp,b,0,new ArrayDeque<Integer>(),0);
        System.out.println(ans1);
        System.out.println(ans2);
	    return ans1;
	}
    private void backtrack(ArrayList<ArrayList<Integer>> ans1,ArrayList<ArrayList<Integer>> ans2,
                            Integer[] A, int B, int sum,
                            Deque<Integer> aux,int pos){
        System.out.println(aux);
            if(sum==B){
                ArrayList<Integer> temp=new ArrayList<Integer>(aux);
                ans2.add(new ArrayList<Integer>(temp));
                Collections.sort(temp);
                System.out.println(temp);
                ans1.add(temp);
                return;
            }
            else if(sum>B) 
                return;
        HashSet<Integer> found = new HashSet<>();
        for(int i=pos;i<A.length;i++){
            //Selecting the element at pos
            if(!found.contains(A[i])){
                found.add(A[i]);
                aux.addLast(A[i]);
                backtrack(ans1,ans2,A,B,sum+A[i],aux,i+1);
                aux.removeLast();
            }
        }
    }
}
