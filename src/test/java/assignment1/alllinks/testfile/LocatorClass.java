package assignment1.alllinks.testfile;

import assignment1.alllinks.utility.UserAction;
import org.openqa.selenium.By;

public class LocatorClass {
    UserAction ua=new UserAction();
    public  By getLoctor(){
        By id= By.xpath(ua.getData(""));
        return id;
    }

}
