package SaucedemoTest;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement boltTShirtAddButton;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement onesieAddButton;
    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("click menu button")
    public ProductsPage clickBurgerMenuButton() {
        burgerMenuButton.click();
        return this;
    }

    @Step("verify if user logged")
    public boolean isLoggedIn() {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(logoutLink)).isDisplayed();
    }

    @Step("add bolt t-shirt to cart")
    public ProductsPage clickAddBoltTShirt() {
        boltTShirtAddButton.click();
        return this;
    }

    @Step("add onesie to cart")
    public ProductsPage clickAddOnesie() {
        onesieAddButton.click();
        return this;
    }

    @Step("click cart link")
    public CartPage clickCartLink() {
        cartLink.click();
        return new CartPage(driver);
    }
}
