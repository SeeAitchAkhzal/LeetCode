package leetcode.misc;

import org.junit.Test;

public class TaskSchedulerTest {

    @Test
    public void test() {
        (new TaskScheduler()).leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }
        , 2);
    }
}
