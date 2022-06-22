package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By SignIn = By.id("nav-link-accountList-nav-line-1");
    private By userName = By.id("nav-link-accountList-nav-line-1");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public signInPage clickSignIn(){
        driver.findElement(SignIn).click();
        return new signInPage(driver);

    }
    public String getUserNameText(){
        return driver.findElement(userName).getText();

    }
}
