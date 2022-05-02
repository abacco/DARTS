package test;

import main.EagerTestPresent;
import org.junit.jupiter.api.Test;

public class ExceptionTestPresent {

    @Test
    public void test1() {
        try {
            System.out.println("ciao");
        } catch(Exception e){
            System.out.println(e);
        }
    }
}