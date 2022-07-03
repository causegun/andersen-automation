package SaucedemoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public ProductsPage clickBurgerMenuButton() {
        burgerMenuButton.click();
        return this;
    }

    public boolean isLoggedIn() {
        return logoutLink.isDisplayed();
    }

    public ProductsPage clickAddBoltTShirt() {
        boltTShirtAddButton.click();
        return this;
    }

    public ProductsPage clickAddOnesie() {
        onesieAddButton.click();
        return this;
    }

    public CartPage clickCartLink() {
        cartLink.click();
        return new CartPage(driver);
    }
}
