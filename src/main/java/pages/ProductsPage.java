package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProductsPage {
    private final WebDriver driver;

    private final By inventoryContainerPath = By.id("inventory_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInventoryContainer () {
        return this.driver.findElement(inventoryContainerPath);
    }
}
