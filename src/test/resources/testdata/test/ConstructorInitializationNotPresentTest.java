package test;

import org.junit.Assert;
import org.junit.Test;

public class ConstructorInitializationNotPresentTest {

    @Test
    public void testKeyAffectsTag()  {
        int a = 1;
        Assert.assertEquals(1,a);
    }
}