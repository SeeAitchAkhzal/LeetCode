package leetcode.string;

/**
 * Runtime: 19 ms, faster than 73.35% of Java online submissions for String to Integer (atoi).
 */
public class StringToInteger {
    public int myAtoi(String str) {

        if(str == null || str.length() == 0) return 0;
        int i = 0;
        int len = str.length();
        boolean isNeg = false;

        // skip leading whitespace
        while(i < len && str.charAt(i) == ' ') i++;

        if(i < len && str.charAt(i) == '-') isNeg = true;

        if(i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) i++;

        int result = 0;
        int pow = 10;
        boolean flag = false;
        boolean start = false;

        while(i<len) {

            char digit = str.charAt(i);

            if(digit >= '0' && digit <= '9') {
                start = true;
                if(result != 0){
                    if(isNeg){
                        if(-1.0*Integer.MIN_VALUE/result < pow ) return Integer.MIN_VALUE;

                    }else{
                        if(1.0*Integer.MAX_VALUE/result < pow) return Integer.MAX_VALUE;
                    }
                }


                result *= pow;

                int d = digit -'0';

                if(isNeg){
                    if(result + Integer.MIN_VALUE > -1 * d ){
                        return Integer.MIN_VALUE;
                    }
                } else{
                    if(Integer.MAX_VALUE - result < d ){
                        // System.out.println(  result);
                        return Integer.MAX_VALUE;
                    }
                }
                result += d;

                flag = true;
            } else {
                if(!flag) return 0;
                else{
                    break;
                }
            }

            i++;
        }

        return isNeg? -1*result : result;
    }
}
