package Add_New_Store;

import Admin_Login_Page.Login_Page_Element;
import Setup_Page.Setup_Selenium;
import Setup_Page.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Store_Element_Run extends Setup_Selenium {

    Store_Element testStore;
    Utils utils;

    @Test
    public void Create_New_Store() throws IOException, ParseException, InterruptedException {
        driver.get("https://6ammart.sixamtech.com/dev/login/admin");
        testStore = new Store_Element(driver);
        utils = new Utils(driver);
        utils.readJSONArray(0);
        String VerifyDashboard = testStore.Create_New_Store(utils.getEmail(), utils.getPassword());
//        Assert.assertEquals(VerifyDashboard, "Grocery Dashboard.");
//        System.out.println(VerifyDashboard);

    }


}
