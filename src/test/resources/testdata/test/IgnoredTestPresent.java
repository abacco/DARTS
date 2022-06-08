package test;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class IgnoredTestPresent {

        @Ignore
        @Test
        public void test_JUnit1() {
                System.out.println("This is the testcase test_JUnit1() in this class");
        }
        @Test
        public void test_JUnit2() {
                System.out.println("This is the testcase test_JUnit2() in this class");
        }
        @Test
        public void test_JUnit3() {
                System.out.println("This is the testcase test_JUnit3() in this class");

        }
}