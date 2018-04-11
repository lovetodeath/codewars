package Kakao;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SecretMapTest {
    @Test
    public void mapTest() {
        String[] arr1 = SecretMap.calculator(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        String[] arr2 = new String[]{"#####","# # #", "### #", "#  ##", "#####"};
        for(int i=0; i < arr1.length; i++) {
            assertEquals("assertEquals error", arr1[i], arr2[i]);
        }
    }
}