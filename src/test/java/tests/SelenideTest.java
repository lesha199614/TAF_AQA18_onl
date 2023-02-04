package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class SelenideTest extends BaseTest {

    @Test
    public void loginTest() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#password").val(ReadProperties.password());
        SelenideElement loginButton = $("#button_primary");
        loginButton
                .should(exist)
                .shouldBe(enabled)
                .click();


//        $(withText("All Projects"))
//                .shouldBe(visible)
//                .shouldHave(text("All Projects"));
//
        $(By.xpath("//div[contains(text(),'All Projects')]"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

//        $$(withText("All Projects"))
//                .shouldBe(empty)
//                .shouldBe(size(10))
//                .texts();
//

//        ==Contains
//        $(withText("All Projects"))
//                .shouldBe(visible)
//                .shouldHave(text("All Projects"));

//        $(byTitle("All Projects"))
//                .shouldBe(visible)
//                .shouldHave(text("All Projects"));

//        $(byValue("All Projects"))
//                .shouldBe(visible)
//                .shouldHave(text("All Projects"));

//        loginButton.pressEnter();
//        добавление текста к элементу (не заменяет)
//        loginButton.append("tjkj");


        $$(withText("All Projects"))
                .shouldHave(texts("text1"
                        , "text2"
                        , "text3"))
                .filterBy(text("Expected text"))
                .excludeWith(hidden)
                .findBy(visible);

        isChrome();

    }

    @Test
    public void loginTest2() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#password").val(ReadProperties.password());
        SelenideElement loginButton = $("#button_primary");
        loginButton
                .should(exist)
                .shouldBe(enabled)
                .click();

        $(By.xpath("//div[contains(text(),'All Projects')]"))
                .shouldBe(visible)
                .shouldHave(text("All Projects"));
    }
}
