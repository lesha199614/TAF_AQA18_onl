package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivDoubleTest extends BaseTest {

    @Test (testName = "Положительное деление на ноль")
    public void divDoubleZeroPositive() {
        Assert.assertEquals(calculator.divDouble(5, 0),Double.POSITIVE_INFINITY);
    }
    @Test (testName = "Деление нуля на ноль")
    public void divDoubleZero() {
        Assert.assertEquals(calculator.divDouble(0, 0),Double.NaN);
    }

    @Test (testName = "Отрицательное деление на ноль")
    public void divDoubleZeroNegative() {
        Assert.assertEquals(calculator.divDouble(-5, 0),Double.NEGATIVE_INFINITY);
    }

    @Test(testName = "Одинаковые значения")
    public void divEqual() {
        Assert.assertEquals(calculator.divDouble(5.2, 5.2), 1);
    }

    @Test(testName = "Дробный результат")
    public void divFractionalResult() {
        Assert.assertEquals(calculator.divDouble(1, 5), 0.2);
    }

    @Test(testName = "Дробное на целое", timeOut = 1000)
    public void divFractionalResult2() throws InterruptedException {
        Thread.sleep(200);
        Assert.assertEquals(calculator.divDouble(5.6, 2), 2.8);
    }

    @Test(testName = "Целое на дробное", threadPoolSize = 3, invocationCount = 10)
    public void divPoolSize() {
        Assert.assertEquals(calculator.divDouble(5, 2.5), 2);
    }

}
