package testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase1(){

        System.out.println("这是测试用例1");
    }

    @BeforeMethod
    public void beforeMethod(){

        System.out.println("这是方法之前");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是方法之后");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("这是类之前");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是类之后");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("这是套件之前");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("这是套件之后");
    }
}
