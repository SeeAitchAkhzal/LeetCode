package leetcode.arrays;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        int lp = 1;
        for(int i=0;i<n;i++){

            output[i] = lp;
            lp *= nums[i];
        }

        int rp = 1;
        for(int i=n-1;i>=0;i--){
            output[i] *= rp;
            rp*=nums[i];
        }

        return output;
    }
}
