package Admin_Login_Page;

import Setup_Page.Setup_Selenium;
import Setup_Page.Utils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_Page_Test_Runner extends Setup_Selenium {


    Login_Page_Element testReg;
    Utils utils;

    @Test
    public void Login_With_Valid_user() throws IOException, ParseException, InterruptedException {
        driver.get("https://6ammart.sixamtech.com/dev/login/admin");
        testReg = new Login_Page_Element(driver);
        utils = new Utils(driver);
        utils.readJSONArray(0);
        testReg.Login_With_Valid_user(utils.getEmail(), utils.getPassword());

    }
}
