/**
 * Created by erez on 07/04/2017.
 */
import UIhandler.*;
import org.openqa.selenium.WebDriver;

public class Runner {

    public static void main(String args[]){

        try{
        driverHandler handler =new driverHandler();
        WebDriver driver = handler.getDriver();
        handler.openBrowser("STMW",driver);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
