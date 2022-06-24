package SaucedemoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationPage {
    WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By usernameBy = By.id("user-name");
    private final By passwordBy = By.id("password");
    private final By loginButtonBy = By.id("login-button");
    private final By authorizationErrorHeaderBy = By.xpath("//h3[contains(@data-test, 'error')]");


    public void loginUser(String username, String password) {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginButtonBy).click();
    }

    public String getAuthorizationErrorText() {
        return driver.findElement(authorizationErrorHeaderBy).getText();
    }
}
