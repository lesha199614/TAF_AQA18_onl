package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest {

    Calculator calculator = new Calculator();

    @Test(priority = 0)
    public void testb() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }

    @Test(priority = 1)
    public void testa() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }

    @Test(priority = 2)
    public void testd() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }

    @Test(priority = 3)
    public void testc() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }

}
