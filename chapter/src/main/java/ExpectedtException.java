import org.testng.annotations.Test;

public class ExpectedtException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccesss(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }

}
