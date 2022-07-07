package SaucedemoTest;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage {
    private WebDriver driver;

    @FindBy(id="first-name")
    private WebElement firstNameInput;
    @FindBy(id="last-name")
    private WebElement lastNameInput;
    @FindBy(id="postal-code")
    private WebElement postalCodeInput;
    @FindBy(id="continue")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("first name entry")
    public CheckoutStepOnePage typeInFirstNameInput(String firstName) {
        firstNameInput.sendKeys(firstName);
        return new CheckoutStepOnePage(driver);
    }

    @Step("last name entry")
    public CheckoutStepOnePage typeInLastNameInput(String lastName) {
        lastNameInput.sendKeys(lastName);
        return new CheckoutStepOnePage(driver);
    }

    @Step("postal code entry")
    public CheckoutStepOnePage typeInPostalCodeInput(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
        return new CheckoutStepOnePage(driver);
    }

    @Step("click \"Continue\" button")
    public CheckoutStepTwoPage clickContinueButton() {
        continueButton.click();
        return new CheckoutStepTwoPage(driver);
    }
}
