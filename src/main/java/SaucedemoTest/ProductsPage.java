package SaucedemoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    private final By burgerMenuButtonBy = By.id("react-burger-menu-btn");
    private final By logoutLinkBy = By.id("logout_sidebar_link");
    private final By boltTShirtAddButtonBy = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By onesieAddButtonBy = By.id("add-to-cart-sauce-labs-onesie");
    private final By cartLinkBy = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBurgerMenuButton() {
        driver.findElement(burgerMenuButtonBy).click();
    }

    public boolean isLoggedIn() {
        return driver.findElements(logoutLinkBy).size() > 0;
    }

    public void clickAddBoltTShirt() {
        driver.findElement(boltTShirtAddButtonBy).click();
    }

    public void clickAddOnesie() {
        driver.findElement(onesieAddButtonBy).click();
    }

    public void clickCartLink() {
        driver.findElement(cartLinkBy).click();
    }
}
