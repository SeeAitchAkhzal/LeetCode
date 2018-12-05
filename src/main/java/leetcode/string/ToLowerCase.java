package leetcode.string;

class ToLowerCase {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
     * @param str
     * @return
     */
    public String toLowerCase(String str) {

        char[] a = str.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 'Z' && a[i] >= 'A') {
                a[i] += 32;
            }
        }

        return new String(a);
    }
}

