package test;

import org.junit.Assert;
import org.junit.Test;
/**
 * Test senza istanza di smell
 */
public class TestMN_Sys_0_instance {

    private final static int UNO = 1;
    @Test
    public void test0() {
        int a=1;
        Assert.assertEquals(UNO,a);
    }
}