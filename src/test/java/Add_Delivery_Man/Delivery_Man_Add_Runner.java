package Add_Delivery_Man;
import Setup_Page.Setup_Selenium;
import Setup_Page.Utils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;

public class Delivery_Man_Add_Runner extends Setup_Selenium {
    Delivery_Man_Adding_Element TestDelivery;
    Utils utils;

    @Test
    public void Delivery_Man_Create() throws IOException, ParseException, InterruptedException {
        driver.get("https://6ammart.sixamtech.com/dev/login/admin");
        TestDelivery = new Delivery_Man_Adding_Element(driver);
        utils = new Utils(driver);
        utils.readJSONArray(0);
        TestDelivery.Delivery_Man_Create(utils.getEmail(), utils.getPassword());

    }

}
