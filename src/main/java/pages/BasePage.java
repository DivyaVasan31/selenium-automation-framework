package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 
                        Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Click element safely
    protected void click(WebElement element) {
        wait.until(ExpectedConditions
                .elementToBeClickable(element));
        element.click();
    }

    // Type into field
    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions
                .visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    // Get text from element
    protected String getText(WebElement element) {
        wait.until(ExpectedConditions
                .visibilityOf(element));
        return element.getText();
    }

    // Check element is displayed
    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Select dropdown by visible text
    protected void selectByText(WebElement element, 
                                String
