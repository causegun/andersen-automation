package ValveTest;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobsPage {
    private WebDriver driver;
    @FindBy(xpath = "//a[@href='about']")
    private WebElement aboutHeader;

    public JobsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebElement jobs(String job) {
        return driver.findElement(By.xpath(String.format("//a[text()='%s']", job)));
    }

    private WebElement otherJobSectionName(String job) {
        return driver.findElement(By.xpath(String.format("//h5[contains(text(),'%s')]", job)));
    }

    @Step("verify if \"other\" section contains job naming")
    public boolean isOtherSectionContainsJobNaming(String job) {
        jobs(job).click();
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable
                (otherJobSectionName(job))).isDisplayed();
    }

    @Step("get \"about\" header text")
    public String getAboutHeaderText() {
        return aboutHeader.getText();
    }

}
