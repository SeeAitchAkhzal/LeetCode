package leetcode.string;

/**
 * Runtime: 2 ms, faster than 99.80% of Java online submissions for Valid Palindrome.
 */
public class ValidPalindrome {
    boolean isAlphaNumeric(char c) {
        if(c>='a' && c<='z')
            return true;

        if( c>='0' && c<='9')
            return true;

        if(c>='A' && c<='Z')
            return true;

        return false;
    }

    boolean isLetter(char c){
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }

    public boolean isPalindrome(String s) {

        if(s.length() <=1) return true;

        int x = 0;
        int y = s.length()-1;

        while(x<y) {

            char charAtX = s.charAt(x);
            if(!isAlphaNumeric(charAtX)){
                x++;
                continue;
            }

            char charAtY = s.charAt(y);
            if(!isAlphaNumeric(charAtY)){
                y--;
                continue;
            }

            if(charAtX != charAtY){
                if(isLetter(charAtX) && isLetter(charAtY)){
                    if((charAtX - 32 != charAtY) && (charAtX != charAtY - 32)){
                        return false;
                    }
                } else{
                    return false;
                }
            }
            x++;
            y--;


        }

        return true;
    }
}
