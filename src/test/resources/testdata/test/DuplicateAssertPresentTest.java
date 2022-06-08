package test;
import org.junit.Test;

public class DuplicateAssertPresentTest {

    @Test
    public void test4() {
        Assert.assertEquals(1, 1);
        Assert.assertEquals(1, 1);
    }
}