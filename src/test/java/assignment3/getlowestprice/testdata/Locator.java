package assignment3.getlowestprice.testdata;

import assignment3.getlowestprice.base.Utility;
import org.openqa.selenium.By;

public class Locator {
    Utility ul=new Utility();

    public static By searchText(){
        By searchText=By.xpath(Utility.findProp("searchText"));
        return searchText;
    }
    public static By click(){
        By cb=By.xpath(Utility.findProp("searchButton"));
        return cb;
    }
    public static By itemList(){
        By ilist=By.xpath(Utility.findProp("listForSearch"));
        return ilist;
    }
    public static By priceList(){
        By plist=By.xpath(Utility.findProp("listForPrice"));
        return plist;
    }
}
