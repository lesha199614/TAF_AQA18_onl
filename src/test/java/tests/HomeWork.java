package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void saucedemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        // товар + цена
        //className
        Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), "Sauce Labs Bike Light");
        //class css
        Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_name")).getText(), "Sauce Labs Bike Light");
        //tag+class css
        Assert.assertEquals(driver.findElement(By.cssSelector("div.inventory_item_name")).getText(), "Sauce Labs Bike Light");
        //price xpath
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'inventory_item_price']")).getText(), "$9.99");
        //linkText
        Assert.assertEquals(driver.findElement(By.linkText("Sauce Labs Bike Light")).getText(), "Sauce Labs Bike Light");
        //PartialLinkText
        Assert.assertEquals(driver.findElement(By.partialLinkText("Sauce Labs")).getText(), "Sauce Labs Bike Light");
        // xPath поиск по текст
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).getText(), "Sauce Labs Bike Light");

        //Отработка лекции на других элементах
        //id
        Assert.assertEquals(driver.findElement(By.id("checkout")).getText(), "CHECKOUT");
        //name
        Assert.assertEquals(driver.findElement(By.name("continue-shopping")).getText(), "CONTINUE SHOPPING");
        //tagName
        Assert.assertEquals(driver.findElement(By.tagName("span")).getText(), "1");
        //css name
        Assert.assertEquals(driver.findElement(By.cssSelector("[name='remove-sauce-labs-bike-light']")).getText(), "REMOVE");
        //id css
        Assert.assertEquals(driver.findElement(By.cssSelector("#checkout")).getText(), "CHECKOUT");
        //tagName css
        Assert.assertEquals(driver.findElement(By.cssSelector("span")).getText(), "1");
        //.class1.class2 css
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn.btn_secondary.cart_button")).isDisplayed());
        // [attribute~=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[class~='cart_list']")).isDisplayed());
        //[attribute|=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[data-test|='remove']")).isDisplayed());
        //[attribute^=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[id^='shopping']")).isDisplayed());
        //[attribute$=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[class$='uantity']")).isDisplayed());
        //[attribute*=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[class*='pricebar']")).isDisplayed());
        //xPath Поиск по частичному совпадению текста например By.xpath("//tag[contains(@attribute,'text')]");
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@id,'remove')]")).isDisplayed());
        //xPath Поиск по частичному совпадению текста например By.xpath("//tag[contains(text(),'text')]");
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).isDisplayed());
        //xPath ancestor
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_item_price']/ancestor::div[4]")).isDisplayed());
        //xPath parent
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cart_quantity']/parent::*")).isDisplayed());
        //xPath descendant
        Assert.assertTrue(driver.findElement(By.xpath("//body//div//button[@id='react-burger-menu-btn']")).isDisplayed());
        //xPath following
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cart_desc_label']//following::button[@id='checkout']")).isDisplayed());
        //xPath preceding
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cart_footer']//preceding::span[1]")).isDisplayed());
        //xPath поиск элемента с условием AND
        Assert.assertTrue(driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bike-light' and @name='remove-sauce-labs-bike-light']")).isDisplayed());

    }
}
