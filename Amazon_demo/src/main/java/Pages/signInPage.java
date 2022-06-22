package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signInPage {
    private  WebDriver driver;
    private By emailField = By.id("ap_email");
    private By passwordField = By.id("ap_password");
    private By continueButton = By.id("continue");
    private By signInButton = By.id("signInSubmit");
    private By statusAlert = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[1]/div/div/div/div/ul/li/span");
    public signInPage(WebDriver driver) {
        this.driver = driver;
    }
    public  void setEmail(String email)  {

        driver.findElement(emailField).sendKeys(email);
    }
    public void clearEmailField(){

        driver.findElement(emailField).clear();
       // driver.manage().deleteAllCookies();
    }
    public  void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clearPassowrdField(){
        driver.findElements(passwordField).clear();
    }
    public void clickContinousButton(){
        driver.findElement(continueButton).click();

    }
    public void clickSignInButton(){
        driver.findElement(signInButton).click();

    }
    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }
}
