package test;

import org.junit.Assert;
import org.junit.Test;

public class CondTestLogicPresentIf {

    @Test
    public void test1() {
        if (1 == 1)
            Assert.assertEquals(1, 1);
        else
            Assert.assertEquals(2, 2);
    }
}