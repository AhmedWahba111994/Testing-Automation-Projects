import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class clinderTests {
    AppiumDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11");
        //caps.setCapability("app", "Calendar");
        caps.setCapability("deviceName", "Android Emulator");
        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
    @Test(priority = 1)
    public void dateClickTest(){
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Calendar\"]")).click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        assertEquals(driver.findElement(By.xpath("//android.view.View[@content-desc=\"Nothing planned. Tap to create.\"]")), "Nothing planned. Tap to create.","Date is Not Correct");
    }
    @Test(priority = 2)
    public void addDateEvents(){
        driver.findElement(By.id("floating_action_button")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        assertEquals(driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Reminder button\"]")),"December","Date is Not Correct");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ImageView")).click();
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        driver.findElement(By.id("title_edit_text")).sendKeys("My BirthDay");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Start date: Wed, Dec 22, 2021\"]/android.widget.LinearLayout/android.widget.TextView")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"22 December 2021\"]")).click();
        driver.findElement(By.id("button1")).click();
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        driver.findElement(By.id("save")).click();
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        assertEquals(driver.findElement(By.xpath("//android.view.View[@content-desc=\"Reminder: My Birthday, All day: ")),"My Birthday","Message is not correct");
    }

}
