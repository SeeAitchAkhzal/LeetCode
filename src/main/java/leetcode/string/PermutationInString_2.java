package leetcode.string;

import java.util.HashMap;

public class PermutationInString_2 {
    HashMap<Character, Integer> orig = new HashMap();
    HashMap<Character, Integer> counts = new HashMap();

    void createOrigHashMap(String s1){
        for(int i=0;i< s1.length();i++) {
            char c = s1.charAt(i);
            orig.put(c, orig.getOrDefault(c, 0) + 1);
        }
    }

    boolean areEqual(){
        if (orig.size() != counts.size())
            return false;

        for(Character c : orig.keySet()){
            if(!counts.containsKey(c) ||
               !counts.get(c).equals(orig.get(c)))
                return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()) return false;
        int n = s1.length();

        createOrigHashMap(s1);

        for(int i=0;i<s2.length();i++){
            char c = s2.charAt(i);
            if(orig.containsKey(c)) {
                counts.put(c, counts.getOrDefault(c, 0)+1);
            }

            if(i-n + 1>=0){

                if(areEqual()) return true;

                char p = s2.charAt(i-n+1);
                if(counts.containsKey(p)) {
                    int pCount = counts.get(p);
                    if(pCount == 0) counts.remove(p);
                    else{
                        counts.put(p, pCount - 1);
                    }
                }
            }

        }

        return false;
    }

}
