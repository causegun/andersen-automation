package SaucedemoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


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
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size() > 0) {
            try {
                PrintWriter printWriter = new PrintWriter(String.valueOf(allLogRows.hashCode()));
                for (LogEntry logRow : allLogRows) {
                    printWriter.println(logRow);
                }
                printWriter.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("verify standard user authorization")
    @Test
    void standardUserAuthorization() {
        assert (authorizationPage
                .loginValidUser()
                .clickBurgerMenuButton()
                .isLoggedIn());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("verify locked out user authorization")
    @Test
    void lockedOutUserAuthorization() {
        assert (authorizationPage
                .loginLockedOutUser()
                .getAuthorizationErrorText().equals("Epic sadface: Sorry, this user has been locked out."));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("verify unaccepted username authorization")
    @Test
    void unacceptedUsernameAuthorization() {
        assert (authorizationPage
                .unacceptedUsernameLogin()
                .getAuthorizationErrorText().equals("Epic sadface: Username and password do not match any user in this service"));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("verify success order")
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
