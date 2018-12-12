package leetcode.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Runtime: 6 ms, faster than 5.08% of Java online submissions for Letter Combinations of a Phone Number.
 */
public class LetterCombinationsOfaPhoneNumber {

    List<String> results = new ArrayList();
    HashMap<Character, Set<Character>> map = new HashMap();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0)
            return results;

        map.put('2', new HashSet(Arrays.asList('a', 'b', 'c')));
        map.put('3', new HashSet(Arrays.asList('d', 'e', 'f')));
        map.put('4', new HashSet(Arrays.asList('g', 'h', 'i')));
        map.put('5', new HashSet(Arrays.asList('j', 'k', 'l')));
        map.put('6', new HashSet(Arrays.asList('m', 'n', 'o')));
        map.put('7', new HashSet(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new HashSet(Arrays.asList('t', 'u', 'v')));
        map.put('9', new HashSet(Arrays.asList('w', 'x', 'y', 'z')));

        combinator(new StringBuilder(), digits);
        return results;

    }

    void combinator(StringBuilder comb, String rem) {

        if (rem == null || rem.length() == 0) {
            results.add(comb.toString());
            return;
        }

        Set<Character> set = map.get(rem.charAt(0));

        for (Character ch : set) {
            comb.append(ch);
            combinator(comb, rem.substring(1));
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
