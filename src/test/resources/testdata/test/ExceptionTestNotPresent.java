package test;

import main.EagerTestPresent;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ExceptionTestNotPresent {

    @Test
    public void test1() {
        int tryi = 1;
        Assert.assertEquals(1,tryi);
    }
}