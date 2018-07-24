package leetcode;

public class String_ReverseCharacters {

    public String reverseString(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        char[] array = s.toCharArray();

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

        return new String(array);
    }
}
