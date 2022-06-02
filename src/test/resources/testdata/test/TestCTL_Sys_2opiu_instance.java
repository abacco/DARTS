package test;

import org.junit.Assert;
import org.junit.Test;
/**
 * Test con 2 o più istanze di smell
 */
public class TestCTL_Sys_2opiu_instance {

    @Test
    public void test0() {
        int a=0;
        if(true){
            a=1;
        }
        Assert.assertEquals(1,a);
    }

    @Test
    public void test1() {
        int a=0;
        if(true){
            a=1;
        }
        for(int i=0; i<2; i++){
            a=1
        }
        switch (1){
            case 1: a=1;break;
        }
        Assert.assertEquals(1,a);
    }

    @Test
    public void test2() {
        int a=0;
        if(true){
            a=1;
        }
        for(int i=0; i<2; i++){
            a=1
        }
        switch (1){
            case 1: a=1;break;
        }
        if(true){
            a=1;
        }
        for(int i=0; i<2; i++){
            a=1
        }
        switch (1){
            case 1: a=1;break;
        }
        Assert.assertEquals(1,a);
    }
}