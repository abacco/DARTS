package test;

import org.junit.Assert;
import org.junit.Test;

public class MagicNumberPresentTest {

    @Test
    public void test1() {
        int numeroUno = 1;
        Assert.assertEquals(1,numeroUno);
    }

    @Test
    public void test2() {
        int numeroUno = 1;
        numeroUno++;
        Assert.assertNotEquals(1,numeroUno);
    }

    @Test
    public void test3() {
        int numeroUno = 1;
        Assert.assertEquals(1,numeroUno);
    }
}