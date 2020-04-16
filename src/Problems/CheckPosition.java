package Problems;

import java.util.Arrays;

public class CheckPosition {

	public static void main(String[] args) {
		int[] ans = {1,3,4,0,0,0,0};
		CheckPosition cPosition = new CheckPosition();
		cPosition.placeInB(ans, 5);
		
		System.out.println(Arrays.toString(ans));

	}
	void placeInB(int[] ans,int sum){
        for(int i=1;i<ans.length;i++){
            
        	if(sum<=ans[i]){
               
                for(int j=ans.length-1;j>=i;j--){
                   ans[j] = ans[j-1];
                }
                ans[i] = sum;
                break;
            }else if(ans[i]==0)
            	{ans[i]=sum;break;}
        }
    }

}
