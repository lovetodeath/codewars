package Kakao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewsClusteringTest {
    @Test
    public void test() {
        assertEquals("fail", NewsClustering.jacad("FRANCE","french"), 16384);
        assertEquals("fail", NewsClustering.jacad("handshake","shake hands"), 65536);
        assertEquals("fail", NewsClustering.jacad("aa1+aa2","AAAA12"), 43690);
        assertEquals("fail", NewsClustering.jacad("E=M*C^2","e=m*c^2"), 65536);
    }
}