package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDown {

    private UIElement uiElement;
    private List<UIElement> uiElementList;
    private List<String> valueList;
    private List<String> textList;

    public DropDown(WebDriver driver, String attributeNameValue) {
        uiElement = new UIElement(driver, By.xpath("//label[contains(text(),'" + attributeNameValue + "')]/parent::*"));
        uiElementList = new ArrayList<>();
        valueList = new ArrayList<>();
        textList = new ArrayList<>();
        for (WebElement webElement : driver.findElements(By.xpath("//label[contains(text(),'" + attributeNameValue + "')]/parent::*//option"))) {
            UIElement option = new UIElement(driver, webElement);
            uiElementList.add(option);
            valueList.add(option.getAttribute("value").trim());
            textList.add(option.getAttribute("text").trim());
        }
    }


    public String SettledValueOfDropDown() {
        return uiElement.findUIElement(By.xpath(".//a/span")).getText().trim();
    }

    public void openSelection() {
        if (isDropDownOpen()) {
            return;
        }
        uiElement.findElement(By.xpath("./div")).click();
    }

    public void selectByIndex(int index) {
        openSelection();
        uiElement.findUIElements(By.xpath(".//li")).get(index).click();
    }

    public void selectByValue(String value) {
        openSelection();
        uiElement.findUIElements(By.xpath(".//li")).get(valueList.indexOf(value)).click();
    }

    public void selectByText(String text) {
        openSelection();
        uiElement.findUIElements(By.xpath(".//li")).get(textList.indexOf(text)).click();
    }

    private boolean isDropDownOpen() {
        return !uiElement.findUIElement(By.xpath(".//div[@class='chzn-drop']"))
                .getAttribute("style").contains("display: none");
    }
}
