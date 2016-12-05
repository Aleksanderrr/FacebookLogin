package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){super(driver);}
    String baseUrl = "https://www.facebook.com";

    public void open(){
        driver.get(baseUrl);
    }

    public void enterLogin(String login){
        By by = By.id("email");
        sendKeys(by, login);
    }

    public void enterPassword(String password){
        By by = By.id("pass");
        sendKeys(by, password);
    }

    public void clickLogin(){
        By by = By.xpath("//input[contains(@type, 'submit')]");
        clickBy(by);
    }

    public void login(String login, String password){
        enterLogin(login);
        enterPassword(password);
        clickLogin();
    }

    public String getBodyText() {
        By by = By.tagName("body");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        WebElement body = driver.findElement(by);
        return body.getText();
    }


}
