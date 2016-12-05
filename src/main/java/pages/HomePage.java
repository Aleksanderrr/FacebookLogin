package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){super(driver);}

    public boolean isLogoutMenuVisible(){
        By by = By.id("logoutMenu");
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }
}
