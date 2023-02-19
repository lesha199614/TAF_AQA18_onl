package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.UserGUI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void loginSuccessfulTest() {
        UserGUI userGUI = new UserGUI.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();
        Assert.assertTrue(
                userStep.loginSuccessful(userGUI)
                        .isPageOpened()
        );
    }
//comment
    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "sdfsdfsdf")
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }
}
