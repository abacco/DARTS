import org.junit.Test;


public class DuplicateAssertPresent {
    @Test
    public void test4() {
        Assert.assertEquals(1, 1);
        Assert.assertEquals(1, 1);
        Assert.assertEquals(1, 1);
    }
}