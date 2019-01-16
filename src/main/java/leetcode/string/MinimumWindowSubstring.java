package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime: 153 ms, faster than 4.02% of Java online submissions for Minimum Window Substring.
 */
public class MinimumWindowSubstring {

    HashMap<Character,Integer> freq = new HashMap();
    HashMap<Character, Integer> curr = new HashMap();
    int bs = -1;
    int be = -1;
    int st = 0;
    int ed = 0;

    private boolean areEqual(HashMap<Character,Integer> m1, HashMap<Character,Integer> m2){

        for(Map.Entry<Character, Integer> entry : freq.entrySet()){
            if(curr.containsKey(entry.getKey())){
                if(curr.get(entry.getKey()) < freq.get(entry.getKey()))
                    return false;
            } else {
                return false;
            }
        }
        return true;
    }

    private void update(int st, int ed) {
        if(be < 0) {
            be = ed;
            bs = st;
        }

        if (ed -st < be -bs){
            be = ed;
            bs = st;
        }
    }

    private void shortenWindow(String s){
        while(st <= ed) {
            char c = s.charAt(st);
            curr.put(c, curr.get(c) - 1);
            st++;

            if(areEqual(curr, freq)) {
                update(st,ed);
            } else{
                break;
            }
        }
    }

    public String minWindow(String s, String t) {

        for(int k=0;k<t.length();k++){
            freq.put(t.charAt(k), freq.getOrDefault(t.charAt(k),0) + 1 );
        }

        while(ed < s.length()) {

            char c = s.charAt(ed);
            curr.put(c, curr.getOrDefault(c, 0) + 1);
            if(areEqual(curr, freq)){
                update(st,ed);
                // shorten window
                shortenWindow(s);
            }

            ed++;
        }

        return be >=0 ? s.substring(bs, be+1) : "";

    }

}
