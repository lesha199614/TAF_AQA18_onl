package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivDoubleTest extends BaseTest {

    @Test(testName = "Положительное деление на ноль")
    public void divDoubleZeroPositive() {
        Assert.assertEquals(calculator.div(5d, 0), Double.POSITIVE_INFINITY);
    }

    @Test(testName = "Деление нуля на ноль")
    public void divDoubleZero() {
        Assert.assertEquals(calculator.div(0d, 0d), Double.NaN);
    }

    @Test(testName = "Отрицательное деление на ноль")
    public void divDoubleZeroNegative() {
        Assert.assertEquals(calculator.div(-5d, 0d), Double.NEGATIVE_INFINITY);
    }

    @Test(testName = "Одинаковые значения")
    public void divEqual() {
        Assert.assertEquals(calculator.div(5.2, 5.2), 1);
    }

    @Test(testName = "Дробный результат")
    public void divFractionalResult() {
        Assert.assertEquals(calculator.div(1d, 5d), 0.2);
    }

    @Test(testName = "Дробное на целое", timeOut = 1000)
    public void divFractionalResult2() throws InterruptedException {
        Thread.sleep(200);
        Assert.assertEquals(calculator.div(5.6, 2), 2.8);
    }

    @Test(testName = "Целое на дробное", threadPoolSize = 3, invocationCount = 10)
    public void divPoolSize() {
        Assert.assertEquals(calculator.div(5, 2.5), 2);
    }

}
