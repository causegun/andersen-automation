package SaucedemoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {
    private WebDriver driver;

    public static final String STANDARD_USER_USERNAME = "standard_user";
    public static final String LOCKED_OUT_USER_USERNAME = "locked_out_user";
    public static final String PASSWORD_FOR_ALL_USERS = "secret_sauce";

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

    private void loginUser(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public ProductsPage loginValidUser() {
        loginUser(STANDARD_USER_USERNAME, PASSWORD_FOR_ALL_USERS);
        return new ProductsPage(driver);
    }

    public AuthorizationPage loginLockedOutUser() {
        loginUser(LOCKED_OUT_USER_USERNAME, PASSWORD_FOR_ALL_USERS);
        return this;
    }

    public AuthorizationPage unacceptedUsernameLogin() {
        loginUser("nonstandard_user", PASSWORD_FOR_ALL_USERS);
        return this;
    }

    public String getAuthorizationErrorText() {
        return authorizationErrorHeader.getText();
    }
}
