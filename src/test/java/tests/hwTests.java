package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hwTests extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement boxElement = waitsService.waitForVisibilityBy(By.id("hot-spot"));
        actions.contextClick(boxElement).build().perform();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");
        alert.accept();
    }

    @Test
    public void dynamicControls () {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = waitsService.waitForVisibilityBy(By.)
    }
}
