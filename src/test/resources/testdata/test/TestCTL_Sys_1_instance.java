package test;

import org.junit.Assert;
import org.junit.Test;
/**
 * Test con 1 istanza di smell
 */
public class TestCTL_Sys_1_instance {

    @Test
    public void test0() {
        int a=0;
        if(true){
            a=1;
        }
        Assert.assertEquals(1,a);
    }
}