package assignment2.logintest.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
public  String setDataFile(String data){
    String UserDir = System.getProperty("user.dir");
    String PathSep = System.getProperty("file.separator");
    String filePath = UserDir + PathSep + "src" + PathSep+"test"+PathSep+"java"+PathSep+"assignment2"+PathSep+"logintest"+PathSep+ "testData" +PathSep+"data.properties";

    Properties prop=new Properties();
    try
    {
        FileReader reader = new FileReader(filePath);

        prop.load(reader);
    } catch (FileNotFoundException e)
    {
        System.out.println("file not found");
    }
    catch (IOException e)
    {
        System.out.println("IOException");

    }
    return prop.getProperty(data);
}
}
