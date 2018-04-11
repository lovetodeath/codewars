package hackerRank.JAVA8;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class challenge_1Test {
    @Test
    public void number_sum() {
        System.out.println("challenge_1Test.test");
        assertEquals("solveMeFirst Error", 5, challenge_1.solveMeFirst(2,3));
        assertEquals("solveMeFirst Error", 15, challenge_1.solveMeFirst(5,10));
    }
}