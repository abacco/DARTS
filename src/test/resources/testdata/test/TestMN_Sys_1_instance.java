package test;

import org.junit.Assert;
import org.junit.Test;
/**
 * Test senza istanza di smell
 */
public class TestMN_Sys_1_instance {

    @Test
    public void test0() {
        int a=0;
        Assert.assertEquals(0,a);
    }
}