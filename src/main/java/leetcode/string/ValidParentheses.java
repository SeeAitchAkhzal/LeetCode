package leetcode.string;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> seen = new Stack();
        int i = 0;

        while (i < s.length()) {

            Character c = s.charAt(i);

            if (c == '{' || c == '[' || c == '(') {
                seen.push(c);
            } else {

                if (seen.size() == 0)
                    return false;

                Character last = seen.pop();

                if (last.equals('{') && !c.equals('}') ||
                    last.equals('[') && !c.equals(']') ||
                    last.equals('(') && !c.equals(')')) {
                    return false;
                }
            }
            i++;
        }

        return seen.size() == 0;

    }
}
