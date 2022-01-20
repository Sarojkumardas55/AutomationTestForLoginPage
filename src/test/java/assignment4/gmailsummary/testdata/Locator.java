package assignment4.gmailsummary.testdata;
import assignment4.gmailsummary.base.Utility;

import org.openqa.selenium.By;

public class Locator {
    Utility ul=new Utility();

    public static By userNmae(){
        By userName=By.xpath(Utility.findProp("uemail1"));
        return userName;
    }
    public static By nextButton(){
        By next=By.xpath(Utility.findProp("next1"));
        return next;
    }

    public static By userPassward(){
        By upw=By.xpath(Utility.findProp("upw1"));
        return upw;
    }
    public static By loginButton(){
        By login=By.xpath(Utility.findProp("login1"));
        return login;
    }
    public static By senderList(){
        By sList=By.xpath(Utility.findProp("listforsender"));
        return sList;
    }
    public static By subList(){
        By sublist=By.xpath(Utility.findProp("listforsub"));
        return sublist;
    }
    public static By timeList(){
        By timelist=By.xpath(Utility.findProp("listfortime"));
        return timelist;
    }
}
