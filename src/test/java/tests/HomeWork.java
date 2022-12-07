package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork {
    private WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void kermiFkoTest() {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        driver.findElement(By.id("el_f_width")).sendKeys("12");
        driver.findElement(By.id("el_f_lenght")).sendKeys("8");
        WebElement roomSelect = driver.findElement(By.id("room_type"));
        Select roomType = new Select(roomSelect);
        roomType.selectByValue("2");
        WebElement heatingSelect = driver.findElement(By.id("heating_type"));
        Select heatingType = new Select(heatingSelect);
        heatingType.selectByValue("3");
        driver.findElement(By.id("el_f_losses")).sendKeys("100");
        driver.findElement(By.name("button")).click();
        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getAttribute("value"), "56");
        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value"), "1");
    }

    @Test
    public void calc() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        driver.findElement(By.xpath("//*[@id=\"cl-consent\"]/div[1]/div[1]/div[2]/a[2]")).click();
        driver.findElement(By.id("ln_room_id")).clear();
        driver.findElement(By.id("ln_room_id")).sendKeys("500");
        driver.findElement(By.id("wd_room_id")).clear();
        driver.findElement(By.id("wd_room_id")).sendKeys("400");
        driver.findElement(By.id("ln_lam_id")).clear();
        driver.findElement(By.id("ln_lam_id")).sendKeys("2000");
        driver.findElement(By.id("wd_lam_id")).clear();
        driver.findElement(By.id("wd_lam_id")).sendKeys("200");
        WebElement direction = driver.findElement(By.id("direction-laminate-id1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", direction); //скролим, чтобы не мешала реклама
        direction.click();
        driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[2]/div[2]/a")).click();
        Thread.sleep(3000); // ждем пока обработается результат
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[1]/span")).getText(), "53");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[2]/span")).getText(), "7");
    }

}
