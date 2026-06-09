package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void initPage() {
        driver.get("https://your-app-url.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, 
          description = "Verify successful login")
    public void testValidLogin() {
        loginPage.login("divya@test.com", "pass123");
        Assert.assertTrue(
            loginPage.getWelcomeMessage()
                      .contains("Welcome"),
            "Welcome message not displayed!");
    }

    @Test(priority = 2,
          description = "Verify login with wrong password")
    public void testInvalidPassword() {
        loginPage.login("divya@test.com", "wrongpass");
        Assert.assertEquals(
            loginPage.getErrorMessage(),
            "Invalid username or password",
            "Error message mismatch!");
    }

    @Test(priority = 3,
          description = "Verify login with empty username")
    public void testEmptyUsername() {
        loginPage.login("", "pass123");
        Assert.assertEquals(
            loginPage.getErrorMessage(),
            "Username is required",
            "Error message mismatch!");
    }

    @Test(priority = 4,
          description = "Verify login with empty password")
    public void testEmptyPassword() {
        loginPage.login("divya@test.com", "");
        Assert.assertEquals(
            loginPage.getErrorMessage(),
            "Password is required",
            "Error message mismatch!");
    }
}
