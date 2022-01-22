package assignment3.getlowestprice.testscript;

import assignment3.getlowestprice.base.Utility;
import assignment3.getlowestprice.base.VerifyStep;
import assignment3.getlowestprice.testdata.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;

public class TestScript1 {
    Utility ul=new Utility();

    WebDriver driver = Utility.lunchDriver();

    @BeforeTest
    public void lunchUrl(){
        driver.get(ul.findProp("url"));
        System.out.println(driver.getTitle());
        VerifyStep.verifyPageTitle(ul.findProp("expTitle"));

    }

    @Test
    public void checkAllItem() throws InterruptedException {

        Utility.enterText(Locator.searchText(),ul.findProp("expSearch"));
        Thread.sleep(5000);

        Utility.click(Locator.click());

        List<WebElement> links = driver.findElements(Locator.itemList());
        if(Utility.isElementPresent(Locator.itemList())) {

            VerifyStep.verifyAllItem(links, ul.findProp("expSearch"));
        }
        else {
            System.out.println("list not found");
        }

    }
@Test(priority = 1)
    public void findLowestPriceDetails(){
        List<WebElement> links1 = driver.findElements(Locator.itemList());
    List<WebElement> links = driver.findElements(Locator.priceList());

   // double lp=VerifyStep.getLowestPriceItem(links);
    if(Utility.isElementPresent(Locator.itemList())) {
        if(Utility.isElementPresent(Locator.priceList())) {
            VerifyStep.getLowestPriceItemDetails(links1, links, ul.findProp("expSearch"));
            // VerifyStep.getLowest(links1,links,ul.findProp("expSearch"));
        }
    }
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
