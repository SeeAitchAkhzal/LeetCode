package leetcode.string;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Runtime: 5 ms, faster than 92.59% of Java online submissions for Longest Common Prefix.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) return "";

        if(strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        int minSize = strs[0].length();
        for(int i=1;i< strs.length;i++) {
            minSize = Math.min(minSize, strs[i].length());
        }


        int i = 0;
        while(i < minSize) {

            char isCommon = strs[0].charAt(i);

            for(int j=1; j<strs.length;j++){
                if(isCommon != strs[j].charAt(i)){
                    i = minSize;
                    break;
                }
            }

            if(i != minSize)
                sb.append(isCommon);

            i++;
        }

        return sb.toString();
    }
}
