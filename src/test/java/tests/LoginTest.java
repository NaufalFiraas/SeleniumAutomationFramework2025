package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        assert loginPage.getLoginBackCol().asHex().equals("#3ddc91");
        loginPage.clickLoginBtn();
        String navigatedURL = this.driver.getCurrentUrl();
        ProductsPage productsPage = new ProductsPage(this.driver);
        Assert.assertEquals(navigatedURL, "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(productsPage.getInventoryContainer().isDisplayed());
    }

    @Test
    public void loginWithUnregisteredUsername() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.inputUsername("abcdef");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("abcde");
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void loginWithoutFillingUsernameField() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.inputUsername("");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWithoutFillingPasswordField() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("");
        loginPage.clickLoginBtn();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }
}
