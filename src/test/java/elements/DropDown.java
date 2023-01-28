package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDown {
    private UIElement uiElement;
    private List<UIElement> uiElementList;
    private List<String> valueList;
    private List<String> textList;

    public DropDown(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public DropDown(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public DropDown(WebDriver driver, String attributeNameValue) {
        //this.uiElement = new UIElement(driver, By.xpath("//label[text()='" + attributeNameValue + "']/parent::*//li"));

                for (WebElement webElement: driver.findElements(By.xpath("//label[text()='" + attributeNameValue + "']/parent::*//li"))){
                    UIElement element = new UIElement(driver, webElement);
                    uiElementList.add(element);
                    valueList.add(element.getAttribute("id"));
                    textList.add(element.getText().trim());
                }
    }
    //label[text()='Template            ']/parent::div
    //label[text()='" + attributeNameValue + "']/parent::*//li
    //'Section            '


    public void click() {
        uiElement.click();
    }
}
