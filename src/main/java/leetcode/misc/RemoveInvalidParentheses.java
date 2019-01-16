package leetcode.misc;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {

    List<String> result = new ArrayList();
    int min = -1;

    public List<String> removeInvalidParentheses(String s) {
        recurse(s, 0, new StringBuilder());
        return result;
    }

    void recurse(String s, int o, StringBuilder sb) {

        if (o < 0)
            return;

        if (s.equals("")) {
            if (o != 0)
                return;
            if (sb.length() > min) {
                result.clear();
                result.add(sb.toString());
                min = sb.length();
            } else if (sb.length() == min && !result.contains(sb.toString())) {
                result.add(sb.toString());
            }

            return;
        }

        char c = s.charAt(0);

        if (c == ')') {

            // keep it
            sb.append(c);
            recurse(s.substring(1), o - 1, sb);
            //remove it
            sb.deleteCharAt(sb.length() - 1);
            recurse(s.substring(1), o, sb);
        } else if (c == '(') {

            // keep it
            sb.append(c);
            recurse(s.substring(1), o + 1, sb);
            // remove it
            sb.deleteCharAt(sb.length() - 1);
            recurse(s.substring(1), o, sb);
        } else {
            sb.append(c);
            recurse(s.substring(1), o, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
