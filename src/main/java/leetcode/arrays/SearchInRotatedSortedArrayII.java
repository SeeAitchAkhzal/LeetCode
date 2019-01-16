package leetcode.arrays;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array II.
 */
public class SearchInRotatedSortedArrayII {

    int[] nums;
    int target;

    public boolean search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return unsortedSearch(0,nums.length-1);
    }


    boolean unsortedSearch(int s, int e){

        if(s > e) return false;

        int mid = (e+s)/2;

        if(nums[mid] > nums[s]){
            if(target <= nums[mid] && target >= nums[s]) return sortedSearch(s, mid);
            else{
                return unsortedSearch(mid+1, e);
            }
        }

        else if (nums[mid]< nums[e]){
            if(target<=nums[e] && target >= nums[mid]) return sortedSearch(mid, e);
            else{
                return unsortedSearch(s, mid-1);
            }
        }
        else{
            if(target == nums[mid]) return true;
            return unsortedSearch(s, mid-1) || unsortedSearch(mid +1, e);
        }
    }


    boolean sortedSearch(int s, int e) {

        while(s<=e){

            int mid = (s+e)/2;

            if(nums[mid] == target) return true;

            else if(nums[mid] > target){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }

        return false;
    }

}
