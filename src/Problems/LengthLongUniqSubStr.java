package Problems;

import java.util.HashSet;

/**
 * LengthLongUniqSubStr
 */
public class LengthLongUniqSubStr {

    public static void main(String[] args) {
        System.out.println(new LengthLongUniqSubStr().lengthOfLongestSubstring("dadbc"));
    }
    public int lengthOfLongestSubstring(String A) {
        HashSet<Character> Ahs = new HashSet<>();
        int start=0,len = 0,ans = Integer.MIN_VALUE;
        for(int j=0;j<A.length();j++){
            char c = A.charAt(j);
            if(!Ahs.contains(c)){
                Ahs.add(c);
                len++;
            }else{
                while(Ahs.contains(c)){
                    Ahs.remove(A.charAt(start));
                    start++;
                    len--;
                }
                Ahs.add(c);
                len++;
            }
            System.out.println(c+":"+len);
            ans = Math.max(ans,len);
        }
    return ans;
    }
}