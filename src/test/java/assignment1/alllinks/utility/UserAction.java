package assignment1.alllinks.utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class UserAction {
    static WebDriver driver;

    public static WebDriver lunchDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
            return false;

        }

    }
    public static   String getPageTitle() {
        String pageText=null;

             pageText = driver.getTitle();
            System.out.println(pageText);

        return pageText;
    }

    public void enterTextValue(By by, String key) {
        if (isElementPresent(by)) {
            driver.findElement(by).sendKeys(key);
            System.out.println("element is present");

        } else {
            System.out.println("element is not present");
        }
    }

    public void click(By by) {
        if (isElementPresent(by)) {
            driver.findElement(by).click();
        } else {
            System.out.println("element is not present");
        }
    }
    public String getData(String data){
        String UserDir = System.getProperty("user.dir");
        String PathSep = System.getProperty("file.separator");
        String filePath = UserDir + PathSep + "src" + PathSep+"test"+PathSep+"java"+PathSep+"assignment1"+PathSep+"alllinks"+PathSep+ "testfile" +PathSep+"file.properties";

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

}
