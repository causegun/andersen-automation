package SaucedemoTest;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AuthorizationPage {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//h3[contains(@data-test, 'error')]")
    private WebElement authorizationErrorHeader;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("login")
    private void loginUser(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    private Properties getCredentialsProperties() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/credentials.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @Step("valid user login")
    public ProductsPage loginValidUser() {
        Properties properties = getCredentialsProperties();
        loginUser(properties.getProperty("username.standard_user"), properties.getProperty("password.valid"));
        return new ProductsPage(driver);
    }

    @Step("locked out user login")
    public AuthorizationPage loginLockedOutUser() {
        Properties properties = getCredentialsProperties();
        loginUser(properties.getProperty("username.locked_out_user"), properties.getProperty("password.valid"));
        return this;
    }

    @Step("unaccepted username login")
    public AuthorizationPage unacceptedUsernameLogin() {
        Properties properties = getCredentialsProperties();
        loginUser("nonstandard_user", properties.getProperty("password.valid"));
        return this;
    }

    @Step("get authorization error text")
    public String getAuthorizationErrorText() {
        return authorizationErrorHeader.getText();
    }
}
