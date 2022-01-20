package assignment2.logintest.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UserAction {

        static WebDriver driver;//= Driver.getInstance().driver;


    /*Method Description: This method is used to check whether the given element is present or not.
    Returns: True, if found
    false, if not found */
        public static boolean isElementPresent(WebElement locator) {
            boolean flag;
            if (locator.isDisplayed()) {
                flag = true;
                System.out.println("flag"+flag);
            } else
            {
                flag = false;
                System.out.println(flag);
            }


            return flag;

           /* System.out.println("true");

            return true;*/
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
        public static void enterValueInTextBox(WebElement locator, String enterText) {

            if (isElementPresent(locator)) {
                locator.sendKeys(enterText);

                System.out.println("locator is  present");
            } else {
                System.out.println("locator is not present");
            }

        }
        /*Method Description: This method is used for click action.
          Returns: Null
        */
        public static void clickButton(WebElement locator) {

            if (isElementPresent(locator)) {
                locator.click();

                System.out.println("locator is  present");
            } else {
                System.out.println("locator is not present");
            }
        }
        public static WebDriver getDriver(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }

    }

