/**
 * Created by erez on 07/04/2017.
 */
import UIhandler.*;
import org.openqa.selenium.WebDriver;

public class Runner {

    public static void main(String args[]){

        driverHandler handler =new driverHandler();
        WebDriver driver = handler.getDriver();
        handler.openBrowser("SA",driver);
    }
}
