package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsTest {

    Calculator calculator = new Calculator();

    @Test(groups = "smoke")
    public void testb() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }

    @Test(groups = "regression")
    public void testa() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }

    @Test(groups = "regression")
    public void testd() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }

    @Test(groups = {"smoke", "regression"})
    public void testc() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Неверная сумма");
    }


}
