package assignment4.gmailsummary.testscript;


import assignment4.gmailsummary.base.Utility;
import assignment4.gmailsummary.base.VerifyStep;
import assignment4.gmailsummary.testdata.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindGmailSumuuary {
    Utility ul=new Utility();


    WebDriver driver = Utility.lunchDriver();

    @BeforeTest
    public void lunchUrl(){
        driver.get(ul.findProp("url1"));
        System.out.println(driver.getTitle());



    }
    @Test
    public void getSummary() throws InterruptedException {
        Utility.enterText(Locator.userNmae(),ul.findProp("email1"));
        Utility.click(Locator.nextButton());

        Thread.sleep(10000);
        Utility.enterText(Locator.userPassward(),ul.findProp("pwd1"));
        Utility.click(Locator.loginButton());
        List<WebElement> links = driver.findElements(Locator.senderList());
        if(Utility.isElementPresent(Locator.senderList())) {

            VerifyStep.addName(links);
        }
        else {
            System.out.println("list not found");
        }
        List<WebElement> links1 = driver.findElements(Locator.subList());
        if(Utility.isElementPresent(Locator.subList())) {

            VerifyStep.addSub(links1);
        }
        else {
            System.out.println("list not found");
        }
        List<WebElement> links2=driver.findElements(Locator.timeList());
        if(Utility.isElementPresent(Locator.timeList())){
            VerifyStep.addTime(links2);
        }
        else {
            System.out.println("list not found");
        }
        VerifyStep.addToCsv();
        //VerifyStep.writeCsv();



    }
    @AfterTest
    public void tearDown(){

    }

}
