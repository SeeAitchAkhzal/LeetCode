package leetcode.arrays;

import java.util.PriorityQueue;

/**
 * Runtime: 5 ms, faster than 78.28% of Java online submissions for Kth Largest Element in an Array.
 */
public class KthLargestElementInAnArray {

    int solution(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for (int i = 0; i < nums.length; i++) {

            if (q.size() < k)
                q.add(nums[i]);
            else if (q.size() == k && q.peek() < nums[i]) {
                q.poll();
                q.add(nums[i]);
            }
        }

        return q.poll();
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<Integer>((i1,i2)->i2-i1);

        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }

        int i = 1;
        int j = -1;
        Integer prev = null;
        while(!q.isEmpty()) {

            j = q.poll();

            if(i == k) return j;

            if(prev == null){
                i++;
            } else{
                if(prev != j)
                    i++;
            }
            prev = j;
        }

        return j;
    }
}

