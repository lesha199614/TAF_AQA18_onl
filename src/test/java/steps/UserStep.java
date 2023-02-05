package steps;

import pages.LoginPage;
import pages.ProductsPage;

public class UserStep {
    private LoginPage loginPage;


    public void login(String email, String psw) {
        loginPage.getEmailInput().val(email);
        loginPage.getPassword().val(psw);
        loginPage.getLogInButton().click();
    }

    public ProductsPage loginSuccessful (String email, String psw) {
        login(email, psw);

        return new ProductsPage();
    }

    public LoginPage loginIncorrect(String email, String psw) {
        login(email, psw);

        return loginPage;
    }
}
