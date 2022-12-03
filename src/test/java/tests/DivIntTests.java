package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivIntTests extends BaseTest {

    @Test(testName = "Деление на ноль", expectedExceptions = ArithmeticException.class)
    public void divIntZero() {
        calculator.divInt(5, 0);
    }

//    Попробовал через Try Catch
//    @Test
//    public void divIntZeroTryCatch(){
//        try {
//            calculator.divInt(5,0);
//        }
//        catch (Exception e) {
//            String expected = e.getMessage();
//            Assert.assertEquals(expected, e.getMessage());
//        }
//    }

    @Test(testName = "Одинаковые значения")
    public void divEqual() {
        Assert.assertEquals(calculator.divInt(5, 5), 1);
    }

    @Test(testName = "Округление")
    public void divFractionalResult() {
        Assert.assertEquals(calculator.divInt(1, 5), 0);
    }

    @Test(testName = "Таймаут", timeOut = 1000)
    public void divFractionalResult2() throws InterruptedException {
        Thread.sleep(200);
        Assert.assertEquals(calculator.divInt(11, 3), 3);
    }

    @Test(testName = "Многопоточный тест", threadPoolSize = 3, invocationCount = 10)
    public void divPoolSize() {
        Assert.assertEquals(calculator.divInt(11, 3), 3);
    }

}
