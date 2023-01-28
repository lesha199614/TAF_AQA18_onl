package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDown {

    //private UIElement uiElement;
    private List<UIElement> uiElementList;
    private List<String> valueList;
    private List<String> textList;

    public DropDown(WebDriver driver, String attributeNameValue) {
        //this.uiElement = new UIElement(driver, By.xpath("//label[contains(text(),'" + attributeNameValue + "')]/parent::*//li"));
        uiElementList = new ArrayList<>();
        valueList = new ArrayList<>();
        textList = new ArrayList<>();
        for (WebElement webElement : driver.findElements(By.xpath("//label[contains(text(),'" + attributeNameValue + "')]/parent::*//li"))) {
            UIElement element = new UIElement(driver, webElement);
            uiElementList.add(element);
            valueList.add(element.getAttribute("id"));
            textList.add(element.getText().trim());
            System.out.println(element.getAttribute("id"));
            System.out.println(element.);
        }
    }
    //label[text()='Template            ']/parent::div
    //label[text()='" + attributeNameValue + "']/parent::*//li
    //'Section            '


}
