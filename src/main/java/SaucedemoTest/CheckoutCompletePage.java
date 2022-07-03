package SaucedemoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'header_secondary_container')]//*[contains(text(), 'Checkout: Complete!')]")
    private WebElement checkoutCompleteSpan;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCheckoutComplete() {
        return checkoutCompleteSpan.isDisplayed();
    }
}
