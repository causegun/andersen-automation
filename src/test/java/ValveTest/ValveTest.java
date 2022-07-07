package ValveTest;

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

public class ValveTest {
    WebDriver driver;
    JobsPage jobsPage;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.valvesoftware.com/");
        jobsPage = new JobsPage(driver);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Severity(SeverityLevel.MINOR)
    @Description("verify job is present")
    @Test
    void verifyJobIsPresent() {
        assert jobsPage.isOtherSectionContainsJobNaming("Software Engineering");
    }

    @Severity(SeverityLevel.MINOR)
    @Description("verify title")
    @Test
    void verifyTitle() {
        assert driver.getTitle().equals("Valve Corporation");
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Description("verify title")
    @Test
    void verifyAboutHeaderText() {
        assert jobsPage.getAboutHeaderText().equals("We make games, Steam, and hardware. Join us.");
    }
}
