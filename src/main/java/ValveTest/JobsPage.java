package ValveTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobsPage {
    WebDriver driver;

    public JobsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String jobNameFromList = "//a[text()='%s']";
    private final String otherJobSectionName = "//h5[contains(text(),'%s')]";

    public boolean isOtherSectionContainsJobNaming(String job) {
        driver.findElement(By.xpath(String.format(jobNameFromList, job))).click();
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable
                        (driver.findElement(By.xpath(String.format(otherJobSectionName, job))))).isDisplayed();
    }

}
