package leetcode.arrays;

public class SumOf3NonOverlappingSubarrays {

    int n;
    int[] nums;
    int k;
    int mSum = Integer.MIN_VALUE;
    int[] sums = new int[3];
    int[] result = new int[3];
    int[] starts = new int[3];

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        n = nums.length;
        this.nums = nums;
        this.k = k;

        findMax(0, n, 0);
        return result;
    }

    void update(){
        int tSum = 0;
        for(int i=0;i<sums.length;i++)
            tSum += sums[i];

        if(tSum > mSum){
            mSum = tSum;
            for(int i=0;i<result.length;i++)
                result[i] = starts[i];
        }
    }

    void findMax(int s, int e, int winNum){

        if(s + k -1 >= e) return;

        int sum = 0;
        int count = 0;

        for(int i=0;i<k;i++, s++){
            sum += nums[s];
        }

        for(int i=s; i<=e; i++) {

            sums[winNum] = sum;
            starts[winNum] = i - k;

            // check for max sum
            if(winNum < 2){
                findMax(i,e, winNum+1);
            } else{
                // Update maximums here
                update();
            }

            if( i != e){
                // move window
                sum -= nums[i-k];
                sum += nums[i];
            }

        }
    }
}


