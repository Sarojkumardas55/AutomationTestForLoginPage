package assignment1.alllinks.utility;

import assignment2.logintest.testCases.LogInTestScript;

import java.io.FileNotFoundException;

public class VerifyStep {
    public static boolean verifyPageTitle(String expectedTitle)  {
        String actualTitle = UserAction.getPageTitle();
    if (actualTitle.equals(expectedTitle)) {
        System.out.println("true");
        return true;
    }
        System.out.println("false");
        return false;

}
}
