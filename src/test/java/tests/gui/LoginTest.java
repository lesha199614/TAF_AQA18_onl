package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void loginSuccessfulTest() {
        User user = new User.Builder()
                .withEmail(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();
        Assert.assertTrue(
                userStep.loginSuccessful(user)
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
