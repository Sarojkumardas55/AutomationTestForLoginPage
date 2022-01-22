package assignment4.gmailsummary.base;

//import demoQaSite.UserAction;

import com.opencsv.CSVWriter;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class VerifyStep {
    /*Method Description: This method is used to verify the title of the page
     Returns: true or false
   */
    public static List<String> name = new ArrayList<>();
    public static List<String> subject = new ArrayList<>();
    public static List<String> time = new ArrayList<>();


    public static boolean verifyPageTitle(String expectedTitle) {
        String actualTitle = UserAction.getPageTitle();
        //System.out.println(actualTitle+"1");
        //System.out.println(expectedTitle+"2");

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("true");
            return true;
        }
        System.out.println("false");

        return false;

    }

    /*Method Description: This method is used to get the data from list<WebElement> and add to another list<String>
     Returns: void
   */
    public static void addName(List list) {
        List<WebElement> links = list;
        for (int index = 0; index < links.size(); index++) {
            WebElement ele = links.get(index);
            String title = ele.getText();
            //System.out.println(title);
            name.add(title);
        }

    }
    /*Method Description: This method is used to get the data from list<WebElement> and add to another list<String>
         Returns: void
       */
    public static void addSub(List list) {
        List<WebElement> links = list;
        for (int index = 0; index < links.size(); index++) {
            WebElement ele = links.get(index);
            String title = ele.getText();
            //System.out.println(title);
            subject.add(title);
        }

    }
    /*Method Description: This method is used to get the data from list<WebElement> and add to another list<String>
         Returns: void
       */
    public static void addTime(List list) {
        List<WebElement> links = list;
        for (int index = 0; index < links.size(); index++) {
            WebElement ele = links.get(index);
            String title = ele.getText();
            //System.out.println(title);
            time.add(title);
        }

    }
            /*Method Description: This method is used to get the data from list<String> and add to a String[] and write the array to csv file
             Returns: void
           */
    public static void addToCsv() {
        String UserDir = System.getProperty("user.dir");
        String PathSep = System.getProperty("file.separator");
        String filePath = UserDir + PathSep + "src" + PathSep + "test" + PathSep + "java" + PathSep + "assignment4" + PathSep + "gmailsummary" + PathSep + "testdata" + PathSep + "output.csv";
        File file = new File(filePath);

        try {
            // create FileWriter object with file as parameter
            FileWriter fileWriter = new FileWriter(file);

            // create CSVWriter with ';' as separator
            CSVWriter writer = new CSVWriter(fileWriter);
//
            String header[] = {"Name", "Subject", "Time"};
            writer.writeNext(header);


            for (int index = 0; index < name.size(); index++) {
//                String data = name.get(i) + ", ";
//                data = data + subject.get(i) + ", ";
//                data = data + time.get(i) + "\n";
//                System.out.println(data);
                String[] emailData = {name.get(index), subject.get(index), time.get(index)};

                // fileWriter.write(data);
                writer.writeNext(emailData);

            }


            // closing writer connection
            writer.close();
            fileWriter.close();
        } catch (IOException e) {

            e.printStackTrace();
            System.out.println("csv file not found");
        }
    }
}
