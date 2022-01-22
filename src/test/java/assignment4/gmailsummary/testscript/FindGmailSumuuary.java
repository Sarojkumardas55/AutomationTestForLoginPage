package assignment4.gmailsummary.testscript;
import assignment4.gmailsummary.base.UserAction;
import assignment4.gmailsummary.base.VerifyStep;
import assignment4.gmailsummary.testdata.Locator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
/*
Class Description: The object of this Test Script is to log in the yahoo mail and take the
                  summary(Sender name,subject,date) and print in a csv file.
 */

public class FindGmailSumuuary {
    UserAction action = new UserAction();


    WebDriver driver = UserAction.lunchDriver();

    @BeforeTest
    public void lunchUrl() {
        driver.get(action.findProp("url1"));

    }
    @Test(priority = 1)
   public void verifyTitleTest(){
        boolean flag=VerifyStep.verifyPageTitle(action.findProp("expTitle"));

        Assert.assertTrue(flag);
   }
   @Test(priority = 2,dependsOnMethods = "verifyTitleTest")
   public void logInTest()  {

       UserAction.enterText(Locator.userNmae(), action.findProp("email1"));
       UserAction.click(Locator.nextButton());

       UserAction.waitForElementIntractable(Locator.userPassward());
       UserAction.enterText(Locator.userPassward(), action.findProp("pwd1"));

       UserAction.click(Locator.loginButton());
       String inboxTitle= driver.getTitle();
       //System.out.println(inboxTitle);
       Assert.assertEquals(inboxTitle, action.findProp("inboxPageTitle"));
   }


    @Test(priority = 3,dependsOnMethods = "logInTest")
    public void getSummaryTest()  {

        List<WebElement> links = driver.findElements(Locator.senderList());
        UserAction.isElementPresent(Locator.senderList());
        VerifyStep.addName(links);
        List<WebElement> links1 = driver.findElements(Locator.subList());
        UserAction.isElementPresent(Locator.subList());
        VerifyStep.addSub(links1);
        List<WebElement> links2 = driver.findElements(Locator.timeList());
        UserAction.isElementPresent(Locator.timeList());
        VerifyStep.addTime(links2);
        VerifyStep.addToCsv();

    }
    @AfterMethod //AfterMethod annotation - This method executes after every test execution
    public void screenShot(ITestResult result){
//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
        if(ITestResult.FAILURE==result.getStatus()){
            UserAction.captureScreenshot(result.getName());
            /*try{
// To create reference of TakesScreenshot
                TakesScreenshot screenshot=(TakesScreenshot)driver;
// Call method to capture screenshot
                File src=screenshot.getScreenshotAs(OutputType.FILE);
// Copy files to specific location
// result.getName() will return name of test case so that screenshot name will be same as test case name
                FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));
                System.out.println("Successfully captured a screenshot");
            }catch (Exception e){
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }*/
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }

}
