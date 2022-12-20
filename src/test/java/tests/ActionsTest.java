package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.WaitsService;

import java.util.List;

public class ActionsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

//    @Test
//    public void hoverTest() {
//        driver.get("http://the-internet.herokuapp.com/hovers");
//
//        WaitsService waitsService = new WaitsService(driver);
//
//        List<WebElement> targetsElements = driver.findElements(By.cssSelector(".figure"));
//
//        Actions actions = new Actions(driver);
//        actions
//                .moveToElement(targetsElements.get(0),10,10)
//                .click(waitsService.waitForExists(By.linkText("View profile")))
//                .build()
//                .perform();
//
//        Assert.assertTrue(waitsService.waitForElementInvisible(targetsElements.get(0)));
//    }

    @Test
    public void hoverTest2() {
        WaitsService waitsService = new WaitsService(driver);
        driver.get("http://the-internet.herokuapp.com/hovers");

        List<WebElement> targetElements = waitsService.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));

        Actions actions = new Actions(driver);
        actions.moveToElement(targetElements.get(0), 10, 10).click(waitsService.waitForExists(By.cssSelector("[href='/users/1']"))).build().perform();

        Assert.assertTrue(waitsService.waitForElementInvisible(targetElements.get(0)));
    }


//    @Test
//    public void fileUploadTest() throws InterruptedException {
//        driver.get("http://the-internet.herokuapp.com/upload");
//
//        WebElement fileUploadElement = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
//        String pathToFile = "src" + File.separator + "test/resources/download.jpeg";
//        System.out.println(pathToFile);
//        fileUploadElement.sendKeys(pathToFile);
//        waitsService.waitForVisibility(By.id("file-submit")).submit();
//
//        Thread.sleep(5000);
//
//
//
//    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        WaitsService waitsService = new WaitsService(driver);
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//input[@type='file']"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath();
        System.out.println(pathToFile);

        fileUploadElement.sendKeys(pathToFile);
        waitsService.waitForVisibility(By.id("file-submit")).submit();

        Assert.assertEquals(waitsService.waitForVisibility(By.id("uploaded-files")).getText().trim(), "download.jpeg");

        Thread.sleep(5000);
    }


}
