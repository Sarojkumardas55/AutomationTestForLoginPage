package assignment3.getlowestprice.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.Status;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utility {

        static WebDriver driver ;//= SingletonChromeDriver.getInstance().driver;
        /*Method Description: This method is used to check whether the given element is present or not.
        Returns: True, if found
        false, if not found */

    public static boolean isElementPresent(By by) {
        boolean isPresent = true;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
            isPresent = false;
        }
        return isPresent;
    }
        public static boolean isSelected(WebElement locator) {

            return true;
        }
        /*Method Description: This method is used to get page Title.
        Returns: Page Title
        */
        public static String getPageTitle() {

            String pageText = driver.getTitle();
            // System.out.println(pageText);


            return pageText;
        }
        /*Method Description: This method is used to Enter the Value in Text box.
          Returns: Null
        */

        public static void enterText(By by,String text)
        {
            if(isElementPresent(by)){
                driver.findElement(by).sendKeys(text);
            }

        }
        /*Method Description: This method is used for click action.
          Returns: Null
        */

        public static void click(By by){
            if(isElementPresent(by)){
                driver.findElement(by).click();
            }
        }
    /*Method Description: This method is used for click radiobutton
      Returns: Null
    */
        public static void radioButton(WebElement locator) {

            if (isSelected(locator)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", locator);
                //locator.click();

                System.out.println("locator is  present");
            } else {
                System.out.println("locator is not present");
            }
        }
    /*Method Description: This method is used to get data from properties file
      Returns: Key Value from file
    */
    public static String findProp(String data){
        String UserDir = System.getProperty("user.dir");
        String PathSep = System.getProperty("file.separator");
        String filePath = UserDir + PathSep + "src" + PathSep+"test"+PathSep+"java"+PathSep+"assignment3"+PathSep+"getlowestprice"+PathSep+ "testdata" +PathSep+"ecom.properties";

        Properties prop=new Properties();
        try
        {
            FileReader reader = new FileReader(filePath);

            prop.load(reader);
        } catch (FileNotFoundException e)
        {
            System.out.println("file not found");
        }
        catch (IOException e)
        {
            System.out.println("IOException");

        }
        return prop.getProperty(data);

    }
    /*Method Description: This method is used to lunch the chrome driver
     Returns: driver
   */
    public static WebDriver lunchDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }



}


