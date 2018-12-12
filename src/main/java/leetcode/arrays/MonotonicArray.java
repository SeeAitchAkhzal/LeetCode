package leetcode.arrays;

public class MonotonicArray {

    /**
     * Runtime: 13 ms, faster than 85.21% of Java online submissions for Monotonic Array.
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A) {

        if(A == null || A.length <=2 ) return true;

        Boolean isIncreasing = null;


        for(int i=0;i<A.length-1;i++){

            int c = A[i];
            int n = A[i+1];
            if(isIncreasing == null){
                if(c > n) isIncreasing = false;
                if(c < n) isIncreasing = true;
            }
            else{
                if((isIncreasing && c > n) ||
                   (!isIncreasing && c < n))
                    return false;
            }
        }

        return true;
    }
}
