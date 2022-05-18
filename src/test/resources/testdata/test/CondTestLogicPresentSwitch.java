package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CondTestLogicPresentSwitch {

    @Test
    public void test1() {
        switch (1){
            case 1: Assert.assertEquals(1,1);
        }
    }
}