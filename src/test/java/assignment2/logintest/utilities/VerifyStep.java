package assignment2.logintest.utilities;

import assignment2.logintest.testCases.LogInTestScript;

import java.io.FileNotFoundException;
/* Test Case Id:
Test Case Description: For verifying the Page Title with Expected Title.
*/
public class VerifyStep {
    UserAction ua = new UserAction();

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
