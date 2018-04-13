package Kakao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CacheTest {
    @Test
    public void test() {
        assertEquals("fail", Cache.solution(3, new String[]{"Jeju","Pangyo","Seoul","NewYork","LA","Jeju","Pangyo","Seoul","NewYork","LA"}), 50);
        assertEquals("fail", Cache.solution(3, new String[]{"Jeju","Pangyo","Seoul","Jeju","Pangyo","Seoul","Jeju","Pangyo","Seoul"}), 21);
        assertEquals("fail", Cache.solution(2, new String[]{"Jeju","Pangyo","Seoul","NewYork","LA","SanFrancisco","Seoul","Rome","Paris","Jeju","NewYork","Rome"}), 60);
        assertEquals("fail", Cache.solution(5, new String[]{"Jeju","Pangyo","Seoul","NewYork","LA","SanFrancisco","Seoul","Rome","Paris","Jeju","NewYork","Rome"}), 52);
        assertEquals("fail", Cache.solution(2, new String[]{"Jeju","Pangyo","NewYork","newyork"}), 16);
        assertEquals("fail", Cache.solution(0, new String[]{"Jeju","Pangyo","Seoul","NewYork","LA"}), 25);
    }
}