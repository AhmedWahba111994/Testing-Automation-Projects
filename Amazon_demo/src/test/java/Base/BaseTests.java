package Base;

import Pages.HomePage;
import Pages.signInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTests {
  private  WebDriver driver;
  protected HomePage homePage;
  protected signInPage signInPage;

@BeforeTest
    public void  setUp(){

       System.setProperty("webdriver.chrome.driver","Drivers//chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("https://admin.development.qawafel.dev/notifications/list");
       driver.manage().window().fullscreen();
       homePage = new HomePage(driver);
       signInPage = new signInPage(driver);
       System.out.println(driver.getTitle());

    }
    @AfterTest
    public void close(){
    driver.quit();
    }
}
