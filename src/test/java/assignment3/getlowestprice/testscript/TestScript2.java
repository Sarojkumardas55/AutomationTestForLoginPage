package assignment3.getlowestprice.testscript;

import assignment3.getlowestprice.base.Utility;
import assignment3.getlowestprice.base.VerifyStep;


import assignment3.getlowestprice.testdata.Locator2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import task.ecom.base.Utility;
//import task.ecom.base.VerifyStep;

import java.util.List;

public class TestScript2 {
    Utility ul = new Utility();

    WebDriver driver = ul.lunchDriver();

    @BeforeTest
    public void lunchUrl() {
        driver.get(ul.findProp("snapdeal"));
        System.out.println(driver.getTitle());
        VerifyStep.verifyPageTitle(ul.findProp("title"));


    }

    @Test(priority = 0)
    public void checkAllItem() throws InterruptedException {
        Utility.enterText(Locator2.searchText(), ul.findProp("expSearch"));
        Thread.sleep(5000);

        Utility.click(Locator2.click());
        Thread.sleep(5000);

        List<WebElement> links = driver.findElements(Locator2.itemList());
        if (Utility.isElementPresent(Locator2.itemList())) {

            VerifyStep.verifyAllItem(links, ul.findProp("expSearch"));
        } else {
            System.out.println("list not found");
        }
    }

    @Test(priority = 1)
    public void findLowestPriceDetails() {
        List<WebElement> links1 = driver.findElements(Locator2.itemList());
        List<WebElement> links = driver.findElements(Locator2.priceList());

        // double lp=VerifyStep.getLowestPriceItem(links);
        if (Utility.isElementPresent(Locator2.itemList())) {
            if (Utility.isElementPresent(Locator2.priceList())) {
                // VerifyStep.getLowestPriceItemDetails(links1, links, ul.findProp("expSearch"));
                VerifyStep.getLowest(links1, links, ul.findProp("expSearch"));
            }
        }

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
