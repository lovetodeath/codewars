package Kakao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DartTest {
    @Test
    public void test() {
        assertEquals("fail", Dart.calculator("1S2D*3T"), 37);
        assertEquals("fail", Dart.calculator("1D2S#10S"), 9);
        assertEquals("fail", Dart.calculator("1D2S0T"), 3);
        assertEquals("fail", Dart.calculator("1S*2T*3S"), 23);
        assertEquals("fail", Dart.calculator("1D#2S*3S"), 5);
        assertEquals("fail", Dart.calculator("1T2D3D#"), -4);
        assertEquals("fail", Dart.calculator("1D2S3T*"), 59);
    }
}