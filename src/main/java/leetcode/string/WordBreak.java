package leetcode.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Runtime: 4 ms, faster than 95.81% of Java online submissions for Word Break.
 */
public class WordBreak {
    Set<String> seen = new HashSet();

    public boolean wordBreak(String s, List<String> wordDict) {

        if(s == null || s.length() == 0) return false;
        return recurse(s, wordDict);
    }


    boolean recurse(String rem, List<String> wordDict) {

        if(seen.contains(rem)) return false;

        if(rem.equals("")) return true;


        for(String s : wordDict) {

            if(rem.startsWith(s)) {
                if(recurse(rem.substring(s.length()), wordDict)) {
                    return true;
                }
            }
            seen.add(rem);
        }

        return false;
    }

}
