package assignment4.gmailsummary.base;

//import demoQaSite.UserAction;
import com.opencsv.CSVWriter;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class VerifyStep {
    /*Method Description: This method is used to verify the title of the page
     Returns: true or false
   */
    public static List<String> name = new ArrayList<>();
    public static List<String> subject = new ArrayList<>();
    public static List<String> time = new ArrayList<>();



    public static boolean verifyPageTitle(String expectedTitle) {
        String actualTitle = Utility.getPageTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("true");
            //Login.appLogin();
            //Login.appLoginDemo();
            return true;
        }
        System.out.println("false");

        return false;

    }

    /*Method Description: This method is used to verify all the items shown is required item or not.
     Returns: void
   */
    public static void addName(List list) {
        List<WebElement> links = list;
        for (int index = 0; index < links.size(); index++) {
            WebElement ele = links.get(index);
            String title = ele.getText();
            System.out.println(title);
            name.add(title);
        }

    }

    public static void addSub(List list) {
        List<WebElement> links = list;
        for (int index = 0; index < links.size(); index++) {
            WebElement ele = links.get(index);
            String title = ele.getText();
            System.out.println(title);
            subject.add(title);
        }

    }

    public static void addTime(List list) {
        List<WebElement> links = list;
        for (int index = 0; index < links.size(); index++) {
            WebElement ele = links.get(index);
            String title = ele.getText();
            System.out.println(title);
            time.add(title);
        }

    }

    public static void addToCsv() {
        String UserDir = System.getProperty("user.dir");
        String PathSep = System.getProperty("file.separator");
        String filePath = UserDir + PathSep + "src" + PathSep + "test" + PathSep + "java" + PathSep + "assignment4" + PathSep + "gmailsummary" + PathSep + "testdata" + PathSep + "output.csv";
        File file = new File(filePath);

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter with ';' as separator
            CSVWriter writer = new CSVWriter(outputfile, ';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            String header[]={"Name","Subject","Time"};
            writer.writeNext(header);


            for (int i = 0; i < name.size(); i++) {
                String data = name.get(i) + ", ";
                data = data + subject.get(i) + ", ";
                data = data + time.get(i) + "\n";
                System.out.println(data);

                outputfile.write(data);
                //writer.writeAll(data1);

            }


            // closing writer connection
            writer.close();
            outputfile.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
