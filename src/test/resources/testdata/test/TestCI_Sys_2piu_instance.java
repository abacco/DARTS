package test;

import org.junit.Assert;
import org.junit.Test;
/**
 * Test senza istanza di smell
 */
public class TestCI_Sys_2piu_instance {

    public TestCI_Sys_2piu_instance(){

    }
    public TestCI_Sys_2piu_instance(String s){

    }
    @Test
    public void test0() {
        int a=0;
        Assert.assertEquals(0,a);
    }
}