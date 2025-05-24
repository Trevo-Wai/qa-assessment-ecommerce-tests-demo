package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    By cardNumber = By.id("card-number");
    By expiry = By.id("card-expiry");
    By cvc = By.id("card-cvc");
    By payNow = By.id("pay-now");

    public void enterPaymentDetails(String card, String exp, String code) {
        driver.findElement(cardNumber).sendKeys(card);
        driver.findElement(expiry).sendKeys(exp);
        driver.findElement(cvc).sendKeys(code);
    }

    public void submitPayment() {
        driver.findElement(payNow).click();
    }
}
