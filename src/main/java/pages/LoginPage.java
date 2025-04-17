package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class LoginPage {
    private final WebDriver driver;

    private final By usernamePath = By.id("user-name");
    private final By passwordPath = By.id("password");
    private final By loginBtnPath = By.id("login-button");
    private final By errorMessagePath = By.xpath("//div[@class='error-message-container error']/h3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username) {
        this.driver.findElement(usernamePath).clear();
        this.driver.findElement(usernamePath).sendKeys(username);
    }

    public void inputPassword(String password) {
        this.driver.findElement(passwordPath).clear();
        this.driver.findElement(passwordPath).sendKeys(password);
    }

    public void clickLoginBtn() {
        this.driver.findElement(loginBtnPath).click();
    }

    public String getErrorMessage() {
        return this.driver.findElement(errorMessagePath).getText();
    }

    public Color getLoginBackCol() {
        return Color.fromString(this.driver.findElement(loginBtnPath).getCssValue("background-color"));
    }
}
