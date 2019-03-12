package leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 3 ms, faster than 99.08% of Java online submissions for Permutations.
 */
public class Permutations {

    List<List<Integer>> result = new ArrayList<>();
    Integer[] perm;
    boolean[] used;
    int[] nums;
    int ind = 0;
    int size = 0;

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0)
            return result;
        this.nums = nums;
        size = nums.length;
        perm = new Integer[size];
        used = new boolean[size];
        permute();
        return result;
    }

    void permute() {

        if (ind == size) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++)
                l.add(perm[i]);
            result.add(l);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!used[i]) {
                perm[ind] = nums[i];
                used[i] = true;
                ind++;
                permute();
                ind--;
                used[i] = false;
            }
        }
    }

}
