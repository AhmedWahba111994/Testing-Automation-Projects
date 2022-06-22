package signIn;

import Base.BaseTests;
import Pages.HomePage;
import Pages.signInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class signInTests extends BaseTests {

    @Test(priority=1)
    public void testInvalidEmails()  {
        signInPage signInPage = homePage.clickSignIn();
        signInPage.setEmail("InvalidEmail");
        signInPage.clickContinousButton();
        assertEquals(signInPage.getAlertText(),"We cannot find an account with that email address","error Message is incoorect");

    }
    @Test(priority=2)
    public void testValidEmails() {
       // signInPage signInPage = new signInPage();
      //  signInPage.setEmail(" ");
        signInPage.clearEmailField();
        signInPage.setEmail("awahba111994@gmail.com");
        signInPage.clickContinousButton();
       // assertEquals(signInPage.getAlertText(),"We cannot find an account with that email address","error Message is incoorect");
    }
    @Test(priority=3)
    public void testInvalidPassword(){
       // signInPage signInPage = homePage.clickSignIn();
        signInPage.setPassword("525161651");
        signInPage.clickSignInButton();
       assertEquals(signInPage.getAlertText(),"Your password is incorrect","error Message is incoorect");
    }
    @Test(priority=4)
    public void testValidPassword(){
        // signInPage signInPage = homePage.clickSignIn();
        signInPage.setPassword("Ax111994");
        signInPage.clickSignInButton();
        assertEquals(homePage.getUserNameText(),"Hello, Ahmed","Welcome Message is incoorect");
    }
}
