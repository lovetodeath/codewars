package Kakao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Friends4BlockTest {
    @Test
    public void test() {
        assertEquals("fail", Friends4Block.calculator(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}), 14);
        assertEquals("fail", Friends4Block.calculator(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}), 15);
    }
}