package seleniumChromestandalone;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;



public class Selenium_ChromeStandalone {

//  This Test case run without any difficulty, do not make unnecessary changes
    // Change string value and port number to run same test case in 2 different browser in docker conatiners
    URL url;
    WebDriver driver;

    @Test
    public void findTitle() throws MalformedURLException, InterruptedException {

        String browser=System.getProperty("browser","chrome");
        //String browser=System.getProperty("browser","firefox");

        DesiredCapabilities cap= new DesiredCapabilities();

        if(browser.contains("chrome")) {
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.LINUX);

        }
        else {
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.LINUX);
        }

         url=new URL("http://localhost:4441/wd/hub");  // for chrome
        // url=new URL("http://localhost:4442/wd/hub");  // for firefox
        driver = new RemoteWebDriver(url, cap);
        driver.get("https://www.google.se/");

        System.out.println("The title is "+driver.getTitle());
        Thread.sleep(30);


    }

}
