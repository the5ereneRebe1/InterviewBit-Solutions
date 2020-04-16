package Problems;

import java.util.ArrayList;

public class GrayCode {
    public static void main(String[] args) {
        // ArrayList<Integer> ans = new GrayCode().grayCode(3);
        // for(int i:ans){
        //     //System.out.println(i);
        //     System.out.println(Integer.toBinaryString(i));
    
    //}
    String s= "ans";
    System.out.println(s.substring(0,1));
    }
	public ArrayList<Integer> grayCode(int a) {
	    if(a==2){
	        ArrayList<Integer> ans =new ArrayList<Integer>();
	        ans.add(0);
	        ans.add(1);
	        ans.add(3);
	        ans.add(2);
	        return ans;
	    }
	    ArrayList<Integer> ans = new ArrayList<Integer>(grayCode(a-1));
	    //make a size a gray code from the returned gray code : use bitmanipulation
	    int n = ans.size()-1;
	    for(int i=n;i>=0;i--){
	        ans.add(ans.get(i));
        }
        System.out.println(ans);
	    n=ans.size();
	    for(int i=0;i<n;i++){
	        if(i<(n/2)){
                int temp = ans.get(i);
                temp=temp|(1<<(a-1));
	            ans.set(i,temp);
	        }     
	    }
	    
	    return ans;
	}
}
