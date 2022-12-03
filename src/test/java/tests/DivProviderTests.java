package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.data.StaticProvider;

public class DivProviderTests {

    Calculator calculator = new Calculator();

    @Test(testName = "Дата Провайдер", dataProvider = "dataForDivTest", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void DataProvider(double a, double b, double expected){
        Assert.assertEquals(calculator.divDouble(a,b),expected, "Неверный результат деления");
    }

}