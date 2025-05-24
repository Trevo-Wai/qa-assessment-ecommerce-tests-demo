package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By checkoutBtn = By.id("checkout-button");

    public void proceedToCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}