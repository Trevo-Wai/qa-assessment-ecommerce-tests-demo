package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.*;

public class PaymentFlowTest {
    WebDriver driver;
    HomePage home;
    CartPage cart;
    CouponPage coupon;
    PaymentPage payment;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lazada.co.th/#?");

        home = new HomePage(driver);
        cart = new CartPage(driver);
        coupon = new CouponPage(driver);
        payment = new PaymentPage(driver);
    }

    @Test
    public void paymentWithCouponTest() {
        home.addToCart();
        cart.proceedToCheckout();

        coupon.applyCoupon("DISCOUNT10"); // <-- applying coupon here

        payment.enterPaymentDetails("4111 1111 1111 1111", "12/25", "123");
        payment.submitPayment();

        String confirmationMessage = driver.getPageSource();
        Assert.assertTrue(confirmationMessage.contains("Payment Successful"), "Payment or coupon failed.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
