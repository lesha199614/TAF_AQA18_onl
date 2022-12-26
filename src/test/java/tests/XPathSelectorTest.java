package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class XPathSelectorTest {

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
    public void xpathLocatorsTest() {
        driver.get("file:/Users/aliakseiv/Documents/IdeaTMS/Auto/TAF_AQA18_onl/TAF_AQA18_onl/src/test/resources/index.html");

        //абсолютный путь
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/ul/li[2]/span[1]")).isDisplayed());

        //все элементы на странице
        Assert.assertEquals(driver.findElements(By.xpath("//*")).size(), 117);

        // Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        // Аналог родительского div и на один уровень ниже h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        // Аналог родительского div и на любом уровне ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        // Поиск элемента с тэгом div у которого есть аттрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением selectorResult
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='selectorResult']")).isDisplayed());

        // Поиск элемента у которого есть аттрибут lang и аттрибут title со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@lang and @title='Hello beautiful']")).isDisplayed());

        // Поиск элемента c аттрибутом lang или class со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@lang or @class=\"noSel newsletter\"]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута начинается с
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'my-Ad')]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@id, 'ess')]")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'We are all animals!']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = '<table>']")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'All my friends')]")).isDisplayed());

        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='markup'][3]")).isDisplayed());

    }

    @Test
    public void xpathAxesTest() {
        driver.get("file:/Users/aliakseiv/Documents/IdeaTMS/Auto/TAF_AQA18_onl/TAF_AQA18_onl/src/test/resources/index.html");

        // Поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::*")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Использование child - непосредственно дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='helpIntro']/span[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='helpIntro']/child::span[1]")).isDisplayed());

        // Использование child - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='helpIntro']//p[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='helpIntro']/descendant::p[1]")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='helpIntro']/following::ul[@id]")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='helpIntro']/preceding::span[1]")).isDisplayed());

        //Использование preceding-sibling/following-sibling - Выбирает все узлы одного уровня до текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='helpIntro']/following-sibling::div[1]")).isDisplayed());


    }

}
