package leetcode.arrays;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (nums[mid] == target)
                return mid;

            // is left sorted
            if (nums[s] <= nums[mid]) {
                if (target >= nums[s] && target < nums[mid])
                    return binarySearch(nums, target, s, mid - 1);
                else
                    s = mid + 1;

            } else {
                if (target > nums[mid] && target <= nums[e])
                    return binarySearch(nums, target, mid + 1, e);
                else
                    e = mid - 1;
            }
        }

        return -1;
    }

    int binarySearch(int[] nums, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }
}
