package leetcode.arrays;

public class MoveZeroes {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Move Zeroes.
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int a = -1;
        int b = 0;
        int len = nums.length;

        while(b < nums.length){

            // first zero found
            if(nums[b] == 0 && a== -1) a=b;

            if(nums[b] != 0 && a != -1){
                nums[a] = nums[b];
                nums[b] = 0;
                a++;
            }
            b++;
        }
    }

}
