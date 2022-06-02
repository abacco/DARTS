package test;

import org.junit.Assert;
import org.junit.Test;
/**
 * Test senza istanza di smell
 */
public class TestEH_Sys_2opiu_instance {

    @Test
    public void test0() {
        int a=0;
        try{
            a = a/0;
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    @Test
    public void test1() {
        int a=0;
        try{
            a = a/0;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        try{
            a = a/0;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        throw new Exception();
    }
    @Test
    public void test1() {
        int a=0;
        try{
            a = a/0;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        try{
            a = a/0;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        throw new Exception();
        try{
            a = a/0;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        try{
            a = a/0;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        throw new Exception();
    }

}