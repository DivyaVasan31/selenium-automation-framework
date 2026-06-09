package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts()
              .implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void takeScreenshotOnFailure(
            org.testng.ITestResult result) {
        if (result.getStatus() == 
                org.testng.ITestResult.FAILURE) {
            org.openqa.selenium.TakesScreenshot ts =
                (org.openqa.selenium.TakesScreenshot) driver;
            java.io.File src = ts.getScreenshotAs(
                org.openqa.selenium.OutputType.FILE);
            try {
                org.apache.commons.io.FileUtils.copyFile(src,
                    new java.io.File("screenshots/" +
                    result.getName() + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
