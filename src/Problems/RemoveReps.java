package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveReps {
    public static void main(String[] args) {
        int data[] ={4,3,3,3,2,2,1};
        System.out.println(Arrays.toString(RemoveReps.solution(data, 1)));
    }
    public static int[] solution(int[] data, int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<data.length;i++){
            if(map.containsKey(data[i])){
                int temp = map.get(data[i]);
                temp++;
                map.replace(data[i],temp);
            }else{
                map.put(data[i],1);
            }
        }
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            if(map.get(data[i])<=n){
                temp.add(data[i]);
            }
        }
        int[] ans = new int[temp.size()];
        for(int i=0;i<ans.length;i++)
            ans[i]=temp.get(i);
    
        return ans;
    }
}