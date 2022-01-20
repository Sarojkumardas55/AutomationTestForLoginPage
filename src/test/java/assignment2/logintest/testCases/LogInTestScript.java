package assignment2.logintest.testCases;

//import assignment2.logintest.driverLunch.Driver;
import assignment2.logintest.utilities.FileUtility;
import assignment2.logintest.utilities.UserAction;
import assignment2.logintest.utilities.VerifyStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 *
 */

public class LogInTestScript {

    static FileUtility utility=new FileUtility();
     WebDriver driver =UserAction.getDriver(); //Driver.getInstance().driver;
    @BeforeTest
    public void lunchUrl()
    {
        driver.get(utility.setDataFile("url"));
        VerifyStep.verifyPageTitle(utility.setDataFile("expectedTitle"));
    }
    @Test
    public  void appLogin() {

        WebElement Username =driver.findElement(By.xpath(utility.setDataFile("userid")));//prop.getProperty("userid")));
        WebElement Password =driver.findElement(By.xpath(utility.setDataFile("password")));//prop.getProperty("password")));
        WebElement click = driver.findElement(By.xpath(utility.setDataFile("submit")));//prop.getProperty("submit")));
        //WebElement click = driver.findElement(By.xpath(prop.getProperty("submit")));


        UserAction.enterValueInTextBox(Username,utility.setDataFile("id") );//prop.getProperty("id"));

        UserAction.enterValueInTextBox(Password,utility.setDataFile("pw"));// prop.getProperty("pw"));
        UserAction.clickButton(click);
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
