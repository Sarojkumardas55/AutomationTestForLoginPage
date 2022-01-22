package assignment4.gmailsummary.testdata;

import assignment4.gmailsummary.base.UserAction;

import org.openqa.selenium.By;
/*
Class Description: The
 */

public class Locator {
    UserAction action = new UserAction();

    public static By userNmae() {
        By userName = By.xpath(UserAction.findProp("uemail1"));
        return userName;
    }

    public static By nextButton() {
        By next = By.xpath(UserAction.findProp("next1"));
        return next;
    }

    public static By userPassward() {
        By upw = By.xpath(UserAction.findProp("upw1"));
        return upw;
    }

    public static By loginButton() {
        By login = By.xpath(UserAction.findProp("login1"));
        return login;
    }

    public static By senderList() {
        By sList = By.xpath(UserAction.findProp("listforsender"));
        return sList;
    }

    public static By subList() {
        By sublist = By.xpath(UserAction.findProp("listforsub"));
        return sublist;
    }

    public static By timeList() {
        By timelist = By.xpath(UserAction.findProp("listfortime"));
        return timelist;
    }
}
