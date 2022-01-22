package assignment1.alllinks.testscript;

import assignment1.alllinks.utility.UserAction;
import assignment1.alllinks.utility.VerifyStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestScript1 {

    UserAction ua =new UserAction();
    WebDriver driver;

    public TestScript1() {
        driver = UserAction.lunchDriver();
    }

    @BeforeTest
    public void lunchUrl(){
        driver.get(ua.getData("url"));
        VerifyStep.verifyPageTitle(ua.getData("expTitle"));
    }
    @Test
    public void getNoOfLinks(){
        driver.navigate().to(ua.getData("url1"));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int ln = links.size();
        System.out.println("No of links in webpage = " + ln);

    }
    @Test
    public void getAllLinks(){
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int ln = links.size();
        System.out.println("No of links in webpage = " + ln);
        for (int index = 0; index < links.size(); index++) {
            WebElement E1 = links.get(index);
            // System.out.println(E1.getText())
            String Linktext = E1.getText();
            System.out.println("Link text in webpage  " + index + " " + Linktext);
            System.out.println("Links in the web page " + E1.getAttribute("href"));
        }


    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
