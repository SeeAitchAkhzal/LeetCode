package leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Subsets.
 */
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {

        result.add(new ArrayList<Integer>());

        if(nums.length == 0) return result;

        this.nums = nums;
        for(int i=1;i<=nums.length;i++){
            makeSubsets(i,0, new ArrayList());
        }

        return result;
    }

    void makeSubsets(int len, int curr, List<Integer> set) {

        if(len == curr){
            List<Integer> t = new ArrayList<>();
            t.addAll(set);
            result.add(t);
            return;
        }

        for(int i=curr; i <nums.length;i++){
            set.add(nums[i]);
            makeSubsets(len, i+1, set);
            set.remove(set.size()-1);
        }
    }

}
