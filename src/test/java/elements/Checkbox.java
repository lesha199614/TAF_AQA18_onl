package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
    private UIElement uiElement;

    public Checkbox(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public Checkbox(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public Checkbox(WebDriver driver, String AttributeNameValue) {

    }


//    public RadioButton(WebDriver driver, String attributeNameValue) {
//        uiElementList = new ArrayList<>();
//        valueList = new ArrayList<>();
//        textList = new ArrayList<>();
//
//        for (WebElement webElement : driver.findElements(By.name(attributeNameValue))) {
//            UIElement element = new UIElement(driver, webElement);
//            uiElementList.add(element);
//            valueList.add(element.getAttribute("value"));
//            textList.add(element.findUIElement(By.xpath("parent::*/strong")).getText().trim());
//        }
//    }

}
