package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class PermutationInString {

    HashMap<Character,Integer> count = new HashMap();
    Set<Character> set = new HashSet();
    Queue<Character> q = new LinkedList<Character>();
    int index = 0;

    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()) return false;

        if(s2.length() == 0) return true;

        // get characters frequency count
        for(int i=0;i<s1.length();i++){
            char c = s1.charAt(i);
            if(count.containsKey(c)){
                count.put(c,count.get(c)+1);
            } else{
                count.put(c, 1);
            }
            set.add(c);
        }


        for(index=0;index<s2.length();) {

            char c = s2.charAt(index);
            if(set.contains(c)) {
                if(isMatch(q,s2,index)) {
                    return true;
                } else {
                    while(!q.isEmpty()) {
                        char t = q.poll();
                        count.put(t, count.get(t) +1);
                        set.add(t);
                    }
                }
            } else{
                index++;
            }
        }

        return false;
    }

    boolean isMatch(Queue<Character> q, String s2, int i) {

        while(i < s2.length() && set.size() != 0) {

            char c = s2.charAt(i);

            if(set.contains(c)) {
                int charCount = count.get(c);
                if(charCount == 1){
                    set.remove(c);
                    count.put(c, 0);
                } else{
                    count.put(c, charCount-1);
                }
                q.add(c);
                index++;
            } else if(count.containsKey(c)) {
                // didn't find the char
                while(q.size() != 0) {
                    char g = q.poll();
                    set.add(g);
                    count.put(g, count.get(g) + 1);
                    if(g == c) {
                        set.remove(g);
                        q.add(g);
                        count.put(g, count.get(g) - 1);
                        break;
                    }
                }
                index++;
            }
            else {
                break;
            }
            i++;
        }
        return set.size() == 0;
    }
}
