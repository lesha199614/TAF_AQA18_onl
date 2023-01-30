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
        this.uiElement = new UIElement(driver, By.xpath("//strong[text()='" + AttributeNameValue + "']/parent::*/*[@type='checkbox']"));
    }


    public void setFlag() {
        if(!isSelected()){
            uiElement.click();
        }
    }
    public void removeFlag() {
        if(isSelected()){
            uiElement.click();
        }
    }

    public boolean isSelected() {
        return uiElement.isSelected();
    }

    public String getAttributeName() {
        return uiElement.findElement(By.xpath("//*[@type='checkbox']/parent::*/strong")).getText().trim();
    }

    public boolean isEnabled() {
        return uiElement.isEnabled();
    }

}
