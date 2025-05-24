package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CouponPage {
    WebDriver driver;

    public CouponPage(WebDriver driver) {
        this.driver = driver;
    }

    By couponField = By.id("coupon-code");
    By applyBtn = By.id("apply-coupon");

    public void applyCoupon(String code) {
        driver.findElement(couponField).sendKeys(code);
        driver.findElement(applyBtn).click();
    }
}