package com.example.test.dep;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hongkailiu on 2015-05-28.
 */
public class ATest {
    @Test public void test() throws Exception {
        A a = new A();
        Assert.assertTrue(0 == a.c());
    }
}
