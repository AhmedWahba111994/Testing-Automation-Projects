import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;


import static org.testng.Assert.assertEquals;

public class HomeTests {
    AppiumDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", "D:\\New folder\\desktop\\Amazon.apk");
        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test(priority = 1)
    public void homePageTest() {
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        driver.findElement(By.id("skip_sign_in_button")).click();
        driver.findElement(By.id("btn_redirect_marketplace")).click();
        driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS);
        assertEquals(driver.findElement(By.id("glow_subnav_label")).getText(),"Deliver to Egypt","Welcome Message is not correct");
    }
    @Test(priority = 2)
    public void basketBtnTest() {
        driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
        driver.findElement(By.id("bottom_tab_cart_icon")).click();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        assertEquals(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View[3]")).getText(),"Your Amazon basket is empty"," Message is not correct");
    }
    @Test(priority = 3)
    public void profileBtnTest() {
        driver.findElement(By.id("bottom_tab_me_icon")).click();
        //It takes long time to load profile page so i give the waiting time to 120 sex
        driver.manage().timeouts().implicitlyWait(120 , TimeUnit.SECONDS);
        assertEquals(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ViewSwitcher/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")).getText(),"Sign in for the best experience"," Message is not correct");
    }

}