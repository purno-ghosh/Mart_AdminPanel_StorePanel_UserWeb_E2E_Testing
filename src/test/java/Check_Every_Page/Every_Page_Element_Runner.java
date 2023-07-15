package Check_Every_Page;

import Add_New_Store.Store_Element;
import Setup_Page.Setup_Selenium;
import Setup_Page.Utils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Every_Page_Element_Runner extends Setup_Selenium {

    Every_Page_Element Check_all_Page;
    Utils utils;
    @Test(enabled = true , priority = 0)
    public void Admin_Users_All_Page() throws IOException, ParseException, InterruptedException {
        driver.get("https://6ammart.sixamtech.com/dev/login/admin");
        Check_all_Page = new Every_Page_Element(driver);
        utils = new Utils(driver);
        utils.readJSONArray(0);
        String VerifyDashboard = Check_all_Page.Admin_Users_All_Page(utils.getEmail(), utils.getPassword());
        // Assert.assertEquals(VerifyDashboard, "Grocery Dashboard.");
        // System.out.println(VerifyDashboard);
    }

    @Test(enabled = true , priority = 1)
    public void Transactions_Reports_Tab() throws IOException, ParseException, InterruptedException {
        driver.get("https://6ammart.sixamtech.com/dev/login/admin");
        Check_all_Page = new Every_Page_Element(driver);
        utils = new Utils(driver);
        utils.readJSONArray(0);
        String VerifyDashboard = Check_all_Page.Transactions_Reports_Tab(utils.getEmail(), utils.getPassword());
        // Assert.assertEquals(VerifyDashboard, "Grocery Dashboard.");
        // System.out.println(VerifyDashboard);
    }

}
