package leetcode.misc;

/**
 * Runtime: 20 ms, faster than 13.35% of Java online submissions for Count and Say.
 */
public class CountAndSay {
    public String countAndSay(int n) {

        String curr = "1";

        for(int i=2;i<=n;i++){

            String next = "";
            for(int k=0;k<curr.length();) {

                char c = curr.charAt(k);
                int count  = 0;

                while(k<curr.length() && curr.charAt(k) == c) {
                    count++;
                    k++;
                }

                next += count + Character.toString(c);
            }
            curr = next;
        }

        return curr;
    }

}
