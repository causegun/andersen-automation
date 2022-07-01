package SaucedemoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaucedemoTest {
    public static final String STANDARD_USER_USERNAME = "standard_user";
    public static final String LOCKED_OUT_USER_USERNAME = "locked_out_user";
    public static final String PASSWORD_FOR_ALL_USERS = "secret_sauce";

    WebDriver driver;
    AuthorizationPage authorizationPage;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        authorizationPage = new AuthorizationPage(driver);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void standardUserAuthorization() {
        authorizationPage.loginUser(STANDARD_USER_USERNAME, PASSWORD_FOR_ALL_USERS);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickBurgerMenuButton();
        assert (productsPage.isLoggedIn());
    }

    @Test
    void lockedOutUserAuthorization() {
        authorizationPage.loginUser(LOCKED_OUT_USER_USERNAME, PASSWORD_FOR_ALL_USERS);
        assert (authorizationPage.getAuthorizationErrorText().equals("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    void unacceptedUsernameAuthorization() {
        authorizationPage.loginUser("nonstandard_user", PASSWORD_FOR_ALL_USERS);
        assert (authorizationPage.getAuthorizationErrorText().equals("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    void successOrder() {
        authorizationPage.loginUser(STANDARD_USER_USERNAME, PASSWORD_FOR_ALL_USERS);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickAddBoltTShirt();
        productsPage.clickAddOnesie();
        productsPage.clickCartLink();
        driver.findElement(By.id("checkout")).click();               // this part will be refactored in the next episode
        driver.findElement(By.id("first-name")).sendKeys("Irina");
        driver.findElement(By.id("last-name")).sendKeys("Kairatovna");
        driver.findElement(By.id("postal-code")).sendKeys("Kairatovna");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        assert (driver.findElement(By.xpath("//div[contains(@class, 'header_secondary_container')]//*[contains(text(), 'Checkout: Complete!')]")).isDisplayed());
    }

}
