package ValveTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValveTest {
    WebDriver driver;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.valvesoftware.com/");
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void verifyJobIsPresent() {
        JobsPage jobsPage = new JobsPage(driver);
        assert jobsPage.isOtherSectionContainsJobNaming("Software Engineering");
    }

    @Test
    void verifyTitle() {
        assert driver.getTitle().equals("Valve Corporation");
    }

    @Test
    void verifyAboutHeaderText() {
        JobsPage jobsPage = new JobsPage(driver);
        assert jobsPage.getAboutHeaderText().equals("We make games, Steam, and hardware. Join us.");
    }
}
