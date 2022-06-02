package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CondTestLogicPresentLoopStatement {

    @Test
    public void test1() {
        for(int i=0; i<2; i++){
            System.out.println("Ciao");
        }
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2() {
        int i=0;
        while(i<5){
            i++;
            Assert.assertEquals(1,1);
        }
    }
}