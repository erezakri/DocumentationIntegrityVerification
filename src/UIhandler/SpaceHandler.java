package UIhandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erez on 10/04/2017.
 */
public class SpaceHandler {

    WebDriver driver;
    String spaceName;

    public SpaceHandler(WebDriver driver, String spaceName) {
        this.driver=driver;
        this.spaceName=spaceName;
    }


    /*expand all of the pages in the space sidebar*/
    public void expandAllPages() {

        /*look for the first expand arrow element in the sidebar and click it. will repeat until no more elements found */
            WebDriverWait wait = new WebDriverWait(driver, 3);
        while (true) {
            /*if the element was available but still the click action fail then try again*/
            try {
                System.out.println("waiting for element");
                /*wait for the expand element to be available and clickable. if timed out assume that there are no more expand elements and exit the loop*/
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"plugin_pagetree_childtoggle icon icon-section-closed\"]")));
                }catch (Exception e){
                    System.out.println("all expanded");
                    break;
                }
//                System.out.println(driver.findElement(By.xpath("//*[@class=\"plugin_pagetree_childtoggle icon icon-section-closed\"]")).getAttribute("id"));

                /*double check that the element is available for click action*/
                if (driver.findElement(By.xpath("//*[@class=\"plugin_pagetree_childtoggle icon icon-section-closed\"]")).isDisplayed()) {
                    driver.findElement(By.xpath("//*[@class=\"plugin_pagetree_childtoggle icon icon-section-closed\"]")).click();
                }
            }catch (Exception e){
                continue;
            }
        }
    }


    /*collect all of the pages from the side bar(after epanding) as web elements*/
    List<WebElement> getAllpages(){
    List<WebElement> pages = new ArrayList<>();
        pages=driver.findElements(By.className("plugin_pagetree_children_span"));
        return pages;
    }


}
