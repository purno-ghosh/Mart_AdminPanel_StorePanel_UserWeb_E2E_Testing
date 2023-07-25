package Admin_Store_Setting_Store_Config;
import Add_Delivery_Man.Delivery_Man_Adding_Element;
import Setup_Page.Setup_Selenium;
import Setup_Page.Utils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;

public class Runner_Admin_Store_Setting_Store_Config extends Setup_Selenium {


    Element_Admin_Store_Setting_Store_Config TestDeliveryTakeAway;
    Utils utils;

    @Test
    public void Manage_Item_Setup_Check() throws IOException, ParseException, InterruptedException {
        driver.get("https://6ammart.sixamtech.com/dev/login/admin");
        TestDeliveryTakeAway = new Element_Admin_Store_Setting_Store_Config(driver);
        utils = new Utils(driver);
        utils.readJSONArray(0);
        TestDeliveryTakeAway.Manage_Item_Setup_Check(utils.getEmail(), utils.getPassword());

    }

}
