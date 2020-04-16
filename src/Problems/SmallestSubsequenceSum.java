package Problems;

import java.util.Arrays;

public class SmallestSubsequenceSum{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,3,2,1}, 10)));
        
    }
    public static int[] solution(int[] l, int t) {
        // Your code here
        int start =0,end=-1,sum=0;
        int ans[] = new int[2];
        ans[0]=-1;ans[1]=-1;
            do{
            if(sum<t || start==end){
                if(end+1<l.length){
                    end++;
                    sum+=l[end];
                    } else
                        break;
            }
            else if(sum>t){
                sum-=l[start];
                start++;
            }
            if(sum==t){
                if(compare(l,ans,start,end)){
                    ans[0]= start;
                    ans[1]= end;
                    
                }
                if(end+1<l.length){
                end++;
                sum+=l[end];
                } else
                    break;
                //return ans;
            }
            
            
            System.out.println(start+":"+end+" "+sum);
        }while(start<=end);
        return ans;
    }

    private static boolean compare(int[] l,int[] ans, int start, int end) {
        System.out.println("Checking for:"+start+":"+end);
        if(ans[0]==-1 || ans[1]==-1)
            return true;
        for(int i=start,j=ans[0];i<=end;i++,j++){
            int temp = j<=ans[1]?l[j]:-1;
            if(l[i]<temp)
                return true;
            if(l[i]> temp)
                return false;
        }

    return false;
    }

}