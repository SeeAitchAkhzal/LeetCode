package leetcode.string;

/**
 * Runtime: 6 ms, faster than 53.38% of Java online submissions for Implement strStr().
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {

        int index = -1;
        int i = 0;

        if (haystack.length() < needle.length())
            return index;

        if (haystack.equals(needle))
            return 0;

        while (i < haystack.length()) {

            // can't possibly be a match now. Optimization.
            if (i + needle.length() > haystack.length())
                return -1;

            // match
            int j = i;
            int k = 0;
            boolean match = true;

            for (k = 0; k < needle.length(); k++, j++) {

                if (j == haystack.length()) {
                    match = false;
                    break;
                }

                if (haystack.charAt(j) != needle.charAt(k)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                index = i;
                break;
            }

            i++;
        }

        return index;
    }

}
