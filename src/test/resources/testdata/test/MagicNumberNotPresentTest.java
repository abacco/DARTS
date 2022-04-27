package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MagicNumberNotPresentTest {

    private static final int EXPECTED = 1;

    @Test
    public void test1() {
        int numeroUno = 1;
        Assert.assertEquals(EXPECTED,numeroUno);
    }

    @Test
    public void test2() {
        int numeroUno = 1;
        numeroUno++;
        Assert.assertNotEquals(EXPECTED,numeroUno);
    }

    @Test
    public void test3() {
        int numeroUno = 1;
        Assert.assertEquals(EXPECTED,numeroUno);
    }
}