package leetcode.arrays;

/**
 * Runtime: 6 ms, faster than 96.72% of Java online submissions for Remove Duplicates from Sorted Array.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        int i = 1;
        int j = 1;

        while(j <nums.length){

            if(nums[j] != nums[j-1]){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;

    }

}
