package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By emailPath = By.id("Email");
    private By passwordPath = By.id("Password");
    private By loginBtnPath = By.className("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email) {
        this.driver.findElement(emailPath).clear();
        this.driver.findElement(emailPath).sendKeys(email);
    }

    public void inputPassword(String password) {
        this.driver.findElement(passwordPath).clear();
        this.driver.findElement(passwordPath).sendKeys(password);
    }

    public void clickLoginBtn() {
        this.driver.findElement(loginBtnPath).click();
    }
}
