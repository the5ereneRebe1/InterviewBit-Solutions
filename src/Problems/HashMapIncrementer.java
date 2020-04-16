package Problems;
import java.util.Arrays;
import java.util.HashMap;

class HashMapIncrementer {
    public static void main(String[] args) {
        System.out.println(new HashMapIncrementer().minWindow("ADOBECODEBANC", "ABC"));
    }
    public String minWindow(String A, String B) {
        int start=0,count = 0,len=B.length(),minLen = Integer.MAX_VALUE,starti=-1;
        HashMap<Character,Integer> Ah = new HashMap<>();
        HashMap<Character,Integer> Bh = new HashMap<>();
        for(Character b:B.toCharArray())
           Bh.compute(b,(key,val)->(val==null)?1:++val);
        for(int j=0;j<A.length();j++){
            Character c = A.charAt(j);
            if(Bh.containsKey(c)){
                Ah.compute(c,(key,val)->(val==null)?1:++val);
                if(Ah.get(c)<=Bh.get(c))
                    count++;
            }
            if(count==len){
                char st = A.charAt(start);
                while(  !Bh.containsKey(st) || 
                        (   Bh.containsKey(st) && 
                            (Ah.get(st)>Bh.get(st))
                        )
                    )
                {
                    if(Ah.containsKey(st) && Ah.get(st)>Bh.get(st))
                        Ah.compute(st,(k,v)->--v);
                    start++;
                    st = A.charAt(start);
                }
                if(j-start+1 < minLen){
                    minLen = j-start+1;
                    starti=start;
                }
            }
            System.out.println(count);
        }
        if (starti == -1)  
            return ""; 
    return A.substring(starti,starti+minLen); 
    }
}