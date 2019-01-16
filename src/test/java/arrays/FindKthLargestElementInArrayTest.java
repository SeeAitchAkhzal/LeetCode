package arrays;

import leetcode.arrays.KthLargestElementInAnArray;
import org.junit.Test;

public class FindKthLargestElementInArrayTest {

    @Test
    public void test() {
        System.out.println(new KthLargestElementInAnArray().findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 },
                                                                            4));
    }
}
