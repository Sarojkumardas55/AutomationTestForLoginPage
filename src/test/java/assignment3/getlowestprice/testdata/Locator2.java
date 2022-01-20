package assignment3.getlowestprice.testdata;

import assignment3.getlowestprice.base.Utility;
import org.openqa.selenium.By;

public class Locator2 {
    Utility ul=new Utility();

    public static By searchText(){
        By searchText=By.xpath(Utility.findProp("searchIcon"));
        return searchText;
    }
    public static By click(){
        By cb=By.xpath(Utility.findProp("sButton"));
        return cb;
    }
    public static By itemList(){
        By ilist=By.xpath(Utility.findProp("ForSearch"));
        return ilist;
    }
    public static By priceList(){
        By plist=By.xpath(Utility.findProp("ForPrice"));
        return plist;
    }
}
