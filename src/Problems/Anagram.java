package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Anagram
 */
public class Anagram {

    public static void main(String[] args) {
        List<String> A = new ArrayList<>();
        A.add("cat");
        A.add("god");
        A.add("tac");
        A.add("dog");
        System.out.println(new Anagram().anagrams(A));

    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String, ArrayList<Integer>> anaMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int j = 0; j < A.size(); j++) {
            String s = A.get(j);
            int freqKey[] = new int[26];

            for (int i = 0; i < s.length(); i++) {
                freqKey[s.charAt(i) - 97]++;
            }
            final int j1 = j;
            System.out.println(Arrays.toString(freqKey) + ":" + s);
            anaMap.compute(Arrays.toString(freqKey), (k, v) -> {
                if (v == null)
                    v = new ArrayList<Integer>();
                v.add(j1);
                return v;
            });
        }
        System.out.println(anaMap);
        anaMap.forEach((k, v) -> {
            if (v.size() > 1)
                ans.add(v);                    
        });
        return ans;
    }
}