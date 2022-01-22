package assignment4.gmailsummary.base;
import assignment4.gmailsummary.testdata.Locator;
import com.opencsv.CSVWriter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class UserAction {

    static WebDriver driver;
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
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not found in webpage");
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

    public static void enterText(By by, String text) {
        if (isElementPresent(by)) {
            driver.findElement(by).sendKeys(text);
        }

    }

    /*Method Description: This method is used to wait for given time if the element is not available
                          it give exception ElementNotIntractable .
          Returns: Null
        */
    public static void waitForElementIntractable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (ElementNotInteractableException e) {
            System.out.println("Element is not intractable");
        } catch (TimeoutException e) {
            System.out.println("Time out Exception");
        }
    }
        /*Method Description: This method is used for click action.
          Returns: Null
        */

    public static void click(By by) {
        if (isElementPresent(by)) {
            WebElement locator = driver.findElement(by);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", locator);
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
    public static String findProp(String data) {
        String UserDir = System.getProperty("user.dir");
        String PathSep = System.getProperty("file.separator");
        String filePath = UserDir + PathSep + "src" + PathSep + "test" + PathSep + "java" + PathSep + "assignment4" + PathSep + "gmailsummary" + PathSep + "testdata" + PathSep + "gmail.properties";

        Properties prop = new Properties();
        try {
            FileReader reader = new FileReader(filePath);

            prop.load(reader);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("IOException");

        }
        return prop.getProperty(data);

    }

    /*Method Description: This method is used to lunch the chrome driver
     Returns: driver
   */
    public static WebDriver lunchDriver() {
        String browserName = findProp("browser");
        String PathSep = System.getProperty("file.separator");
        if (browserName.equals("chrome")) {
            // System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "C:" + PathSep + "drivers" + PathSep + "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
        }
       /* WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //return driver;*/
        return driver;
    }

    public static void captureScreenshot(String screenshotName) {
        String UserDir = System.getProperty("user.dir");
        String PathSep = System.getProperty("file.separator");
        String filePath = UserDir + PathSep + "src" + PathSep + "screenshot";// + PathSep + "java" + PathSep + "assignment4" + PathSep + "gmailsummary" + PathSep + "screeenshot" ;

        try {
// To create reference of TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
// Call method to capture screenshot
            File src = screenshot.getScreenshotAs(OutputType.FILE);
// Copy files to specific location
// result.getName() will return name of test case so that screenshot name will be same as test case name
            FileUtils.copyFile(src, new File(filePath  +screenshotName+ ".png"));
            System.out.println("Successfully captured a screenshot");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
}