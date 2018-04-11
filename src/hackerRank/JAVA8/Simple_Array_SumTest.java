package hackerRank.JAVA8;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Simple_Array_SumTest {
    @Test
    public void array_sum_test() {
        assertEquals("array sum error", 31, Simple_Array_Sum.simpleArraySum(new int[]{1,2,3,4,10,11}));
        assertEquals("array sum error", 50, Simple_Array_Sum.simpleArraySum(new int[]{10,10,10,10,10}));
    }
}