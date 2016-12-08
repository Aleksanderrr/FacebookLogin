package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    private static WebDriver driver;
    static LoginPage loginPage;
    static HomePage homePage;
    String correctLogin = "zdzislaw.kiepura@wp.pl";
    String correctPassword = "tojesttest";
    String incorrectPassword = "Bella Ciao!";

    @BeforeClass
    public static void before(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
}

    @Test(enabled = true, priority = -1)
    public void incorrectLogin(){
        //GIVEN
        loginPage.open();
        //WHEN
        loginPage.login(correctLogin, incorrectPassword);
        //THEN
        assertTrue(loginPage.getBodyText().contains("Odzyskaj swoje konto"));
    }

    @Test(enabled = true)
    public void correctLogin(){
        //GIVEN
        loginPage.open();
        //WHEN
        loginPage.login(correctLogin, correctPassword);
        //THEN
        assertTrue(homePage.isLogoutMenuVisible());
    }

    @AfterClass
    public static void after(){
        driver.quit();
    }
}
