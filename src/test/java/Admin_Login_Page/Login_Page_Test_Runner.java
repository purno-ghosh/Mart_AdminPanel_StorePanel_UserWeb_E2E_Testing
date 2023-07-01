package Admin_Login_Page;

import Setup_Page.Setup_Selenium;
import Setup_Page.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_Page_Test_Runner extends Setup_Selenium {


    Login_Page_Element testlogin;
    Utils utils;

    @Test
    public void Login_With_Valid_user() throws IOException, ParseException, InterruptedException {
        driver.get("https://6ammart.sixamtech.com/dev/login/admin");
        testlogin = new Login_Page_Element(driver);
        utils = new Utils(driver);
        utils.readJSONArray(0);
        String VerifyDashboard=testlogin.Login_With_Valid_user(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(VerifyDashboard, "Grocery Dashboard.");
        System.out.println(VerifyDashboard);

    }
}
