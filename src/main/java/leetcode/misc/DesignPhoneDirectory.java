package leetcode.misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Runtime: 68 ms, faster than 84.07% of Java online submissions for Design Phone Directory.
 */
public class DesignPhoneDirectory {

    Set<Integer> used = new HashSet();
    LinkedList<Integer> returned = new LinkedList();
    int counter = 0;
    int max;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public DesignPhoneDirectory(int maxNumbers) {
        this.max = maxNumbers;

    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {

        if (used.size() == max)
            return -1;

        int newNum;
        if (returned.size() > 0) {
            newNum = returned.getFirst();
            returned.removeFirst();
            used.add(newNum);
            return newNum;
        }

        newNum = counter;
        counter++;
        used.add(newNum);

        return newNum;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {

        if (used.size() == max)
            return false;

        return !used.contains(number);

    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {

        if (used.contains(number)) {
            used.remove(number);
            returned.addLast(number);
        }
    }

}
