package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class WordBreakII {

    public void verify() {
        String[] my = new String[] { "aaaa aa a", "aaaa a aa", "aaaa a a a", "aa aaaa a", "aa aa aa a", "aa aa a aa",
                                     "aa a aa"
                                     + " a a", "aa a "
                                               + "aaaa",
                                     "aa a aa aa", "a aa aa a a", "aa a a aa a", "a aa a a aa", "a a a aa a a",
                                     "a aaaa aa", "a aaaa a a", "a aa "
                                                                +
                                                                "aaaa", "a aa aa aa", "a aa aa a a", "aa a a aa a",
                                     "a aa a a aa", "a a a aa a a", "a a aaaa a", "a a aa aa a", "a aa a a aa",
                                     "a a a aa a a", "a a a aaaa", "a a a aa aa", "a a a aa a a", "a a a a aa a",
                                     "a a a a a aa", "a a a a a a a" };

        String[] lc = new String[] { "a a a a a a a", "aa a a a a a", "a aa a a a a", "a a aa a a a", "aa aa a a a",
                                     "aaaa a a a", "a a a aa a a", "aa a aa a a", "a aa aa a a", "a aaaa a a",
                                     "a a a a aa a", "aa a a aa a", "a aa a aa a", "a a aa aa a", "aa aa aa a",
                                     "aaaa aa a", "a a aaaa a", "aa aaaa a", "a a a a a aa", "aa a a a aa",
                                     "a aa a a aa", "a a aa a aa", "aa aa a aa", "aaaa a aa", "a a a aa aa",
                                     "aa a aa aa", "a aa aa aa", "a aaaa aa", "a a a aaaa", "aa a aaaa", "a aa aaaa" };

        HashMap<String, Integer> count1 = new HashMap<>();
        for (String s : my) {
            if (count1.containsKey(s)) {
                count1.put(s, count1.get(s) + 1);
            }
        }

        HashMap<String, Integer> count2 = new HashMap<>();
        for (String s : my) {
            if (count2.containsKey(s)) {
                count2.put(s, count2.get(s) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : count1.entrySet()) {

            if (count2.containsKey(entry.getKey())) {
                if (count2.get(entry.getKey()) != entry.getValue()) {
                    System.out.println("ISSUES");
                }
            } else {
                System.out.println("ISSUES");
            }
        }

        for (Map.Entry<String, Integer> entry : count2.entrySet()) {

            if (count1.containsKey(entry.getKey())) {
                if (count1.get(entry.getKey()) != entry.getValue()) {
                    System.out.println("ISSUES");
                }
            } else {
                System.out.println("ISSUES");
            }
        }

    }
}
