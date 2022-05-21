package test;

import main.EagerTestPresent;
import org.junit.Test;

public class ExceptionTestPresent {

    @Test
    public void test1() {
        try {
            System.out.println("ciao");
        } catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void test2() {
        //CAMBIARE IL BLOCCO TRY CATCH CON IL LANCIO DI UNA ECCEZIONE
        try {
            System.out.println("ciao");
        } catch(Exception e){
            System.out.println(e);
        }
    }
}