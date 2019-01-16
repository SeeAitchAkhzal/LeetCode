package leetcode.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 2 ms, faster than 95.34% of Java online submissions for Generate Parentheses.
 */
public class GenerateParentheses {
    List<String> result = new ArrayList();
    int n;

    public List<String> generateParenthesis(int n) {

        this.n = n;
        StringBuilder sb = new StringBuilder();
        recurse(sb, 0, 0, n*2);

        return result;
    }


    void recurse(StringBuilder sb, int openBrace, int count, int size){

        if(size == 0){
            result.add(sb.toString());
            return;
        }

        if(openBrace > 0){
            recurse(sb.append(')'), openBrace-1, count, size-1);
            sb.deleteCharAt(sb.length() -1);
        }

        if(count < n){
            recurse(sb.append('('), openBrace+1, count+1, size-1);
            sb.deleteCharAt(sb.length() -1);
        }
    }

}
