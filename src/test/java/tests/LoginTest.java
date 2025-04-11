package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail("admin@yourstore.com");
        loginPage.inputPassword("admin");
        loginPage.clickLoginBtn();
        String dashboardTitle = driver.getTitle();
    }

}
