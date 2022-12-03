package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {

    Calculator calculator = new Calculator();

    @Test()
    public void testb() {
        Assert.assertEquals(calculator.sum(2, 3), 6, "Неверная сумма");
    }

    @Test(dependsOnMethods = "testb", alwaysRun = true)
    public void testa() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }

    @Test(dependsOnMethods = "testa")
    public void testd() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }

    @Test(dependsOnMethods = {"testd", "testb"})
    public void testc() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }


}
