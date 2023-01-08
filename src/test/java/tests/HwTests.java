package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HwTests extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement boxElement = waitsService.waitForVisibilityBy(By.id("hot-spot"));
        actions.contextClick(boxElement).build().perform();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
        alert.accept();
    }

    @Test
    public void dynamicControlsTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = waitsService.waitForVisibilityBy(By.cssSelector("[type='checkbox']"));
        checkbox.click();
        //actions.click(checkbox).build().perform(); //alternative
        WebElement removeButton = waitsService.waitForVisibilityBy(By.cssSelector("[onclick = 'swapCheckbox()']"));
        //removeButton.click();
        actions.click(removeButton).build().perform();
        WebElement messageCheckboxLocator = waitsService.waitForVisibilityBy(By.id("message"));
        Assert.assertEquals(messageCheckboxLocator.getText(), "It's gone!");
        Assert.assertFalse(checkElementPresence(checkbox));

        WebElement inputLocator = waitsService.waitForVisibilityBy(By.cssSelector("[type='text']"));
        Assert.assertFalse(inputLocator.isEnabled());
        WebElement enableTextFieldButton = waitsService.waitForVisibilityBy(By.cssSelector("[onclick='swapInput()']"));
        enableTextFieldButton.click();
        WebElement messageTextFieldLocator = waitsService.waitForVisibilityBy(By.id("message"));
        Assert.assertEquals(messageTextFieldLocator.getText(), "It's enabled!");
        Assert.assertTrue(inputLocator.isEnabled());
    }

    @Test
    public void uploadFileTest(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement fileUpload = waitsService.waitForVisibilityBy(By.id("file-upload"));
        String filePath = "/Users/aliakseiv/Documents/IdeaTMS/Auto/TAF_AQA18_onl/TAF_AQA18_onl/src/test/resources/playtika.png";
        String filePathAlternative = HwTests.class.getClassLoader().getResource("playtika.png").getPath();
        fileUpload.sendKeys(filePathAlternative);
        WebElement uploadButton = waitsService.waitForVisibilityBy(By.id("file-submit"));
        uploadButton.click();
        WebElement fileNameLocator = waitsService.waitForVisibilityBy(By.id("uploaded-files"));
        Assert.assertEquals(fileNameLocator.getText(),"playtika.png");
    }

    @Test
    public void iFrameTest () {
        driver.get("http://the-internet.herokuapp.com/iframe");
        WebElement iFrameLocator = waitsService.waitForVisibilityBy(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(iFrameLocator);

    }

}
