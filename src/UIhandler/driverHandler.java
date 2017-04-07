package UIhandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by erez on 07/04/2017.
 */
public class driverHandler {

    final String sitePrefix = "https://docs.experitest.com/display/";

//    WebDriver driver = new FirefoxDriver();

//
//    public WebDriver getDriver() {
//        return driver;
//    }

    public WebDriver getDriver(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\erez\\IdeaProjects\\DocumentationIntegrityVerification\\chromedriver.exe");

        /*disable unsupported error*/
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability("chrome.binary","<<your chrome path>>");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        /*disable pop-up*/
        options.addArguments("--disable-extensions");

        driver = new ChromeDriver(capabilities);
//        driver = new ChromeDriver();
        return driver;
    }


    public void openBrowser(String spaceName,WebDriver driver){
        driver.get(sitePrefix+spaceName);
//        driver.navigate()
    }

}
