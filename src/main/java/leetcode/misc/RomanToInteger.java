package leetcode.misc;

/**
 * Runtime: 71 ms, faster than 29.44% of Java online submissions for Roman to Integer.
 */
public class RomanToInteger {
    public int romanToInt(String s) {

        int result = 0;

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            char next = i+1 < s.length() ? s.charAt(i+1) : '\0';

            if(c == 'I' && next == 'V'){
                result += 4;
                i++;
            }

            else if(c == 'I' && next == 'X'){
                result += 9;
                i++;
            }

            else if(c == 'X' && next == 'L'){
                result += 40;
                i++;
            }


            else if(c == 'X' && next == 'C'){
                result += 90;
                i++;
            }

            else if(c == 'C' && next == 'D'){
                result += 400;
                i++;
            }

            else if(c == 'C' && next == 'M'){
                result += 900;
                i++;
            }

            else {
                if(c == 'I') result += 1;
                if(c == 'V') result += 5;
                if(c == 'X') result += 10;
                if(c == 'L') result += 50;
                if(c == 'C') result += 100;
                if(c == 'D') result += 500;
                if(c == 'M') result += 1000;
            }
        }


        return result;

    }

}
