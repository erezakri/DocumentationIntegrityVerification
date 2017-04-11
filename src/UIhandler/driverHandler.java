package UIhandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by erez on 07/04/2017.
 */
public class driverHandler {

    final String sitePrefix = "https://docs.experitest.com/display/";

//    WebDriver driver = new ChromeDriver();



    public WebDriver getDriver(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\erez\\IdeaProjects\\DocumentationIntegrityVerification\\chromedriver2.29.exe");

        /*disable unsupported error*/
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        /*disable add-on pop-up*/
        options.addArguments("--disable-extensions");

        /*surpress "only local conections are alllows and set futer remoting*/
        ChromeDriverService service = null;
        try {
            service = new ChromeDriverService.Builder().withWhitelistedIps(InetAddress.getLocalHost().getHostAddress()).build();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

//        driver = new ChromeDriver(capabilities);
//        driver = new ChromeDriver();
        driver = new ChromeDriver(service, capabilities);
        return driver;
    }


    public void openBrowser(String spaceName,WebDriver driver) throws InterruptedException {
        driver.manage().window();

//        driver.get("ynet.co.il");
        driver.navigate().to(sitePrefix+spaceName);

        SpaceHandler space = new SpaceHandler(driver,spaceName);
        space.expandAllPages();
        List<WebElement> pages = space.getAllpages();
        driver.close();
    }

}
