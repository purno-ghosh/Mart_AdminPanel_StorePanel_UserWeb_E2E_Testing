package React_Order_Place;

import Add_Delivery_Man.Delivery_Man_Adding_Element;
import Setup_Page.Setup_Selenium;
import Setup_Page.Utils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import org.json.simple.parser.ParseException;
public class React_Website_Run extends Setup_Selenium {
    React_website_Element Rect_test;
    Utils utils;

    @Test
    public void Order_Place() throws IOException, ParseException, InterruptedException {
        driver.get("https://6ammart-react.6amtech.com/");
        Rect_test= new React_website_Element(driver);
        Rect_test.Order_Place();

//        Rect_test.React_Order_Place();



    }

}
