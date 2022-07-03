package SaucedemoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaucedemoTest {

    WebDriver driver;
    AuthorizationPage authorizationPage;
    ProductsPage productsPage;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        authorizationPage = new AuthorizationPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void standardUserAuthorization() {
        assert (authorizationPage
                .loginValidUser()
                .clickBurgerMenuButton()
                .isLoggedIn());
    }

    @Test
    void lockedOutUserAuthorization() {
        assert (authorizationPage
                .loginLockedOutUser()
                .getAuthorizationErrorText().equals("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    void unacceptedUsernameAuthorization() {
        assert (authorizationPage
                .unacceptedUsernameLogin()
                .getAuthorizationErrorText().equals("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    void successOrder() {
        assert (authorizationPage
                .loginValidUser()
                .clickAddBoltTShirt()
                .clickAddOnesie()
                .clickCartLink()
                .clickCheckoutButton()
                .typeInFirstNameInput("Irina")
                .typeInLastNameInput("Kairatovna")
                .typeInPostalCodeInput("666666")
                .clickContinueButton()
                .clickFinishButton()
                .isCheckoutComplete());
    }

}
