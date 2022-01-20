package assignment3.getlowestprice.base;

//import demoQaSite.UserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.*;

public class VerifyStep {
    /*Method Description: This method is used to verify the title of the page
     Returns: true or false
   */
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
    public static void verifyAllItem(List list,String expSearch){
        List<WebElement> links =list;
        for (int index=0;index< links.size();index++){
            WebElement ele= links.get(index);
            String title=ele.getText();
            System.out.println(title);

            if (title.toLowerCase().contains(expSearch.toLowerCase())) {

                System.out.println("product is "+expSearch);

            } else {

                System.out.println("product is not "+expSearch);

            }
        }
    }
    public static double getLowestPriceItem(List list){
        List<WebElement> price=list;
        List<Double> checkbox = new ArrayList<>();
        for (int index=0;index< price.size();index++){
            WebElement ele= price.get(index);
            String priceofitem=ele.getText();
            priceofitem=priceofitem.replace("$","");

            double newPrice = Double.parseDouble(priceofitem);
            //System.out.println(newPrice);
            checkbox.add(newPrice);

        }
        double min = checkbox.stream().min(Comparator.naturalOrder()).get();
        System.out.println("lowest price = $"+min);
        return min;
    }
    /*Method Description: This method is used to find the lowest price in all search item product name.
     Returns: void
   */
    public static void getLowestPriceItemDetails(List list1,List list2,String exp){
        List<WebElement> list_of_products =list1;
        List<WebElement> list_of_products_price =list2;
        //Use of HashMaop to store Products and Their prices
        String productName ="";
        String productPrice="";
        double lowPrice = Double.MAX_VALUE;
        double Price = 0;

        HashMap<Double,String> lowest_price_products = new HashMap<Double,String>();
        for(int index=0;index<list_of_products.size();index++) {
            String productNameTemp = list_of_products.get(index).getText();//Iterate and fetch product name
            String productPriceTemp = list_of_products_price.get(index).getText();//Iterate and fetch product price
           // productPriceTemp=productPriceTemp.replace("Rs.","");
            productPriceTemp=productPriceTemp.replace("$","");
            if (productNameTemp.toLowerCase().contains(exp.toLowerCase())) {
                double newPrice = Double.parseDouble(productPriceTemp);

                if (newPrice < lowPrice){
                    lowPrice = newPrice;
                    productName = productNameTemp;
                    productPrice = productPriceTemp;
                }
            }
             Price = Double.parseDouble(productPrice);

            lowest_price_products.put(Price,productName);
        }
        //System.out.println("all data in map "+map_final_products.toString());
        //System.out.println(productName+productPrice);

        System.out.println("Low Product Price in "+exp+" item is:$ " + Price + " Product name is: " + lowest_price_products.get(Price));
    }
    /*Method Description: This method is used to find the lowest price in all search item product name.
     Returns: void
   */

    public static void getLowest(List lsit1,List list2,String str){
        List<WebElement> list_of_products =lsit1; //driver.findElements(By.xpath("//div[@class='_3wU53n']"));
        List<WebElement> list_of_products_price =list2;// driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));

        //Use of HashMaop to store Products and Their prices(after conversion to Integer)
        String product_name;
        String product_price = null;
        double int_product_price;
        HashMap<Double, String> map_final_products = new HashMap<Double,String>();
        HashMap<Double, String> map_products = new HashMap<Double,String>();
        for(int i=0;i<list_of_products.size();i++) {
            product_name = list_of_products.get(i).getText();
            product_price = list_of_products_price.get(i).getText();
            product_price = product_price.replace("Rs.", "");
            product_price = product_price.replace(",", "");
           // product_price = product_price.replace("$", "");

            double newPrice = Double.parseDouble(product_price);
            if(product_name.toLowerCase().contains(str.toLowerCase())) {

                map_final_products.put(newPrice, product_name);
            }
            else {
                map_products.put(newPrice,product_name);
            }

        }
        //System.out.println("all data in final map "+map_final_products.toString() );
        //System.out.println("all data in  map "+map_products.toString());

        Set<Double> allkeys = map_final_products.keySet();
        ArrayList<Double> array_list_values_product_prices = new ArrayList<Double>(allkeys);

        Collections.sort(array_list_values_product_prices);

        //Highest Product is
        //double high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);

        //Low price is
        double low_price = array_list_values_product_prices.get(0);
        System.out.println("Low Product Price in all item is: Rs." + low_price + " Product name is: " + map_final_products.get(low_price));
       // System.out.println("Low Product Price in all item is: $" + low_price + " Product name is: " + map_final_products.get(low_price));

    }
}
