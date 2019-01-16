package leetcode.misc;

/**
 * Runtime: 2 ms, faster than 96.82% of Java online submissions for Add Binary.
 */
public class AddBinary {
    public String addBinary(String a, String b) {

        int m = a.length()-1;
        int n = b.length()-1;
        String result = "";
        int carry = 0;

        while(m >=0 || n>=0){

            int c1 = 0;
            int c2 = 0;

            if(m >=0){
                c1 = a.charAt(m) -'0';
            }

            if(n >=0){
                c2 = b.charAt(n) -'0';
            }

            int sum = c1+c2 + carry;
            carry = 0;

            if(sum == 0){
                result = "0" + result;
            }

            if(sum == 1){
                result = "1" + result;
            }

            if(sum == 2){
                result = "0" + result;
                carry++;
            }

            if(sum == 3){
                result = "1" + result;
                carry++;
            }

            m--;
            n--;
        }


        return carry > 0 ? "1" + result : result;
    }
}
