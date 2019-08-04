package com.zhoulei.demo;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestMethodsDemo {

    @Test
    public void test1(){

        Assert.assertEquals(1,1);
        System.out.println("这是test1");
    }

    @Test
    public void test2(){

        Assert.assertEquals(1,3);
        System.out.println("这是test2");
    }

    @Test
    public void test3(){

        Assert.assertEquals(3,4);
    }

    @Test
    public void logDemo(){
        System.out.println("成功");
    }
}
