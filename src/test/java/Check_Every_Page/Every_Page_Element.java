package Check_Every_Page;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Every_Page_Element {
    private static String getParentTabHandle(WebDriver driver) {

        return driver.getWindowHandles().iterator().next();
    }

    private static String getNewTabHandle(WebDriver driver) {
        String parentHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentHandle)) {
                return handle;
            }
        }
        return parentHandle;
    }

    WebDriver driver;

    @FindBy(xpath = "//input[@id='signinSrEmail']")
    WebElement emailfld;

    @FindBy(xpath = "//input[contains(@id,'signupSrPassword')]")
    WebElement passfld;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'login')]")
    WebElement logbtn;

    @FindBy(xpath = "//a[contains(.,'Users')]")
    WebElement Usertab;

    public Every_Page_Element(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);

    }

    public String Admin_Users_All_Page(String email, String password) throws InterruptedException {
        emailfld.sendKeys(email);
        passfld.sendKeys(password);
        logbtn.click();
        Thread.sleep(2000);
        Usertab.click();
        Thread.sleep(2000);
        System.out.println("<< ! Starting Automation Testing for Users tab ! >> ");
        String UserOverview = driver.findElement(By.xpath("//h1[@class='page-header-title mb-0'][contains(.,'User Overview')]")).getText();
        System.out.println("TEST 01 UserOverview Dashboard Is OK ! " + UserOverview);

        //DELIVERY MAN MANAGEMENT //Vehicles category Page Verify

        WebElement Vehicles_cat = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Vehicles category')]"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(Vehicles_cat).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String Vehicle_Title = driver.findElement(By.xpath("//h1[@class='page-header-title'][contains(.,'Vehicles category list')]")).getText();
        System.out.println("TEST 02 Vehicles Category Is OK !  " + Vehicle_Title + " ");
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(2000);

        //DELIVERY MAN MANAGEMENT  //Add Delivery Man Page Verify

        WebElement Add_Delivery = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Add Delivery Man')]"));
        Actions actions1 = new Actions(driver);
        actions1.keyDown(Keys.CONTROL).click(Add_Delivery).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String Add_Delivery_Man = driver.findElement(By.xpath("//span[contains(.,'Add New Delivery Man')]")).getText();
        System.out.println("TEST 03 Add Delivery Man Page Is OK ! " + Add_Delivery_Man);
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(2000);

        //DELIVERY MAN MANAGEMENT  // New Delivery Man Page Verify

        WebElement New_Delivery = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'New delivery man')]"));
        Actions actions2 = new Actions(driver);
        actions2.keyDown(Keys.CONTROL).click(New_Delivery).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String New_Delivery_Man = driver.findElement(By.xpath("//h1[@class='page-header-title'][contains(.,'New joining requests')]")).getText();
        System.out.println("TEST 04 New Delivery Man Page is OK !  " + New_Delivery_Man);
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(2000);

        //DELIVERY MAN MANAGEMENT //Delivery Man List Page Verify

        WebElement Delivery_Man = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Deliveryman List')]"));
        Actions actions3 = new Actions(driver);
        actions3.keyDown(Keys.CONTROL).click(Delivery_Man).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String Delivery_Man_lIst = driver.findElement(By.xpath("(//span[contains(.,'Delivery Man')])[2]")).getText();
        System.out.println("TEST 05 Delivery Man List Page is OK !  " + Delivery_Man_lIst);
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(2000);

        //DELIVERY MAN MANAGEMENT  // Reviews Page Verify

        WebElement Reviews = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Reviews')]"));
        Actions actions4 = new Actions(driver);
        actions4.keyDown(Keys.CONTROL).click(Reviews).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String Reviews_page = driver.findElement(By.xpath("//span[contains(.,'Delivery Man Reviews')]")).getText();
        System.out.println("TEST 06 Reviews Page is OK !  " + Reviews_page);
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(2000);

        //CUSTOMER MANAGEMENT // Customers

        WebElement Customers = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Customers')]"));
        Actions actions5 = new Actions(driver);
        actions5.keyDown(Keys.CONTROL).click(Customers).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert = new SoftAssert();
        String Customers_Page = driver.findElement(By.xpath("//span[contains(.,'Customers')]")).getText();
        softAssert.assertTrue(Customers_Page.contains("Customers"), "Customers page assertion failed");
        softAssert.assertAll();
        System.out.println("TEST 07 Customers Page is OK !  " + Customers_Page);
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        Thread.sleep(2000);

        // CUSTOMER MANAGEMENT // Customers // Add Fund

        driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate  text-capitalize'][contains(.,'Customer Wallet')]")).click();
        Thread.sleep(2000);
        WebElement Add_Fund = driver.findElement(By.xpath("//span[@class='text-truncate text-capitalize'][contains(.,'Add Fund')]"));
        Actions actions6 = new Actions(driver);
        actions6.keyDown(Keys.CONTROL).click(Add_Fund).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert0 = new SoftAssert();
        String AddFund_Page = driver.findElement(By.xpath("(//span[contains(.,'Add Fund')])[2]")).getText();
        softAssert0.assertTrue(AddFund_Page.contains("Add Fund"), "Add Fund page assertion failed");
        softAssert0.assertAll();
        System.out.println("TEST 08 Customers > Add Fund page is OK ! " + AddFund_Page);
        Thread.sleep(2000);

        //CUSTOMER MANAGEMENT // Customers // Report

        driver.findElement(By.xpath("(//span[@class='text-truncate text-capitalize'][contains(.,'Report')])[1]")).click();
        Thread.sleep(2000);
        String Report_Page = driver.findElement(By.xpath("//span[contains(.,'Customer Wallet Report')]")).getText();
        System.out.println("TEST 09 Customers > Report Page is OK !  " + Report_Page);

        //CUSTOMER MANAGEMENT // Customers // Bonus
        driver.findElement(By.xpath("//span[contains(.,'Bonus')]")).click();
        Thread.sleep(2000);
        String Wallet_Bonus_Page = driver.findElement(By.xpath("//span[contains(.,'Wallet bonus setup')]")).getText();
        System.out.println("TEST 10 Customers > Wallet_Bonus_Page is OK !  " + Wallet_Bonus_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        //CUSTOMER MANAGEMENT // Customers Loyalty Point

        WebElement loyalty_click = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate  text-capitalize'][contains(.,'Customer Loyalty Point')]"));
        // Scroll to the button element (optional)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", loyalty_click);
        js.executeScript("arguments[0].click();", loyalty_click);
        Thread.sleep(2000);

        WebElement Customer_Loyalty = driver.findElement(By.xpath("(//span[@class='text-truncate text-capitalize'][contains(.,'Report')])[2]"));
        Actions actions7 = new Actions(driver);
        actions7.keyDown(Keys.CONTROL).click(Customer_Loyalty).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert1 = new SoftAssert();
        String Loyalty_Page = driver.findElement(By.xpath("//span[contains(.,'Customer Loyalty Point Report')]")).getText();
        softAssert1.assertTrue(Loyalty_Page.contains("Customer Loyalty Point Report"), "Customers Loyalty Point page assertion failed");
        softAssert1.assertAll();
        Thread.sleep(2000);
        System.out.println("TEST 11 Customers Loyalty Point > Roport in Ok !  " + Loyalty_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        //CUSTOMER MANAGEMENT // Subscribed Emails

        WebElement Subscribed_Emails = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Subscribed Emails')]"));
        Actions actions8 = new Actions(driver);
        actions8.keyDown(Keys.CONTROL).click(Subscribed_Emails).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert2 = new SoftAssert();
        String Subscribed_Page = driver.findElement(By.xpath("//span[contains(.,'Subscribed Emails')]")).getText();
        softAssert2.assertTrue(Subscribed_Page.contains("Subscribed Emails"), "Customers Loyalty Point page assertion failed");
        softAssert2.assertAll();
        Thread.sleep(2000);
        System.out.println("TEST 12 Subscribed Emails page is OK !  " + Subscribed_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        // CUSTOMER MANAGEMENT // Contact Messages

        WebElement Contact_Messages = driver.findElement(By.xpath("//a[@href='https://6ammart.sixamtech.com/dev/admin/users/contact/contact-list']"));
        Actions actions9 = new Actions(driver);
        actions9.keyDown(Keys.CONTROL).click(Contact_Messages).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert3 = new SoftAssert();
        String Messages_Page = driver.findElement(By.xpath("//h2[contains(.,'All message lists')]")).getText();
        softAssert3.assertTrue(Messages_Page.contains("All Message Lists"), "Contact messages page assertion failed");
        softAssert3.assertAll();
        Thread.sleep(2000);
        System.out.println("TEST 13 Contact Messages is OK !  " + Messages_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        //CUSTOMER MANAGEMENT //Employee Role

        WebElement Employee_Role = driver.findElement(By.xpath("//a[@href='https://6ammart.sixamtech.com/dev/admin/users/custom-role/create']"));
        Actions actions10 = new Actions(driver);
        actions10.keyDown(Keys.CONTROL).click(Employee_Role).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert4 = new SoftAssert();
        String Employee_Role_Page = driver.findElement(By.xpath("//span[contains(.,'Employee Role')]")).getText();
        softAssert4.assertTrue(Employee_Role_Page.contains("Employee Role"), "@@ Employee Role page assertion failed");
        softAssert4.assertAll();
        Thread.sleep(2000);
        System.out.println("TEST 14 Employee Role Page is OK !  " + Employee_Role_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        //CUSTOMER MANAGEMENT //Employees //Add New Employee

        driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Employees')]")).click();
        Thread.sleep(2000);
        WebElement Add_new_Employee = driver.findElement(By.xpath("//a[@href='https://6ammart.sixamtech.com/dev/admin/users/employee/add-new']"));
        Actions actions11 = new Actions(driver);
        actions11.keyDown(Keys.CONTROL).click(Add_new_Employee).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert5 = new SoftAssert();
        String AddEmployee_Page = driver.findElement(By.xpath("//span[contains(.,'General information')]")).getText();
        softAssert5.assertTrue(AddEmployee_Page.contains("General Information"), "General Information page assertion failed");
        softAssert5.assertAll();
        Thread.sleep(2000);
        System.out.println("TEST 15 Add New Employee Page is OK ! " + AddEmployee_Page);
        //CUSTOMER MANAGEMENT //Employees //Add New Employee // List

        driver.findElement(By.xpath("//a[@href='https://6ammart.sixamtech.com/dev/admin/users/employee/list']")).click();
        Thread.sleep(2000);
        String EmployeeList_Page = driver.findElement(By.xpath("//span[contains(.,'Employee List')]")).getText();
        System.out.println("TEST 16 Employee Role List Page is OK !  " + EmployeeList_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));
        return null;
    }

    public String Transactions_Reports_Tab(String email, String password) throws InterruptedException {
//        emailfld.sendKeys(email);
//        passfld.sendKeys(password);
//        logbtn.click();
//        Thread.sleep(2000);

        System.out.println("<< ! Starting Automation Testing for Transactions & Reports Tab ! >> ");

        driver.findElement(By.id("tourb-7")).click();
        String Withdraw_Requests = driver.findElement(By.xpath("//span[contains(.,'Store Withdraw Transaction')]")).getText();
        System.out.println("TEST 17 Withdraw Requests Page Is OK !  " + Withdraw_Requests);

        // Transactions_Reports_Tab //BUSINESS MANAGEMENT // Collect Cash

        WebElement Collect_Cash = driver.findElement(By.xpath("//span[contains(.,'Collect Cash')]"));
        Actions actions11 = new Actions(driver);
        actions11.keyDown(Keys.CONTROL).click(Collect_Cash).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert5 = new SoftAssert();
        String Collect_Cash_Page = driver.findElement(By.xpath("//span[contains(.,'Collect Cash Transaction')]")).getText();
        softAssert5.assertTrue(Collect_Cash_Page.contains("Collect Cash Transaction"), "Collect Cash Transaction page failed");
        softAssert5.assertAll();
        Thread.sleep(5000);
        System.out.println("TEST 18 Collect Cash is OK !  " + Collect_Cash_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        // Transactions_Reports_Tab // BUSINESS MANAGEMENT // Delivery Men Payments

        WebElement Delivery_Man_Payments = driver.findElement(By.xpath("//a[contains(.,'Delivery Man Payments')]"));
        Actions actions12 = new Actions(driver);
        actions12.keyDown(Keys.CONTROL).click(Delivery_Man_Payments).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert6 = new SoftAssert();
        String Delivery_Man_Payment_Page = driver.findElement(By.xpath("//span[contains(.,'provide Delivery Men Earning')]")).getText();
        softAssert6.assertTrue(Delivery_Man_Payment_Page.contains("Provide Delivery Men Earning"), "Delivery_Man_Payments page assertion failed");
        softAssert6.assertAll();
        Thread.sleep(5000);
        System.out.println("TEST 19 Delivery Men Payments Page is OK !  " + Delivery_Man_Payment_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        // Transactions_Reports_Tab // REPORT & ANALYTICS //Transection Report
        WebElement Transection_Report = driver.findElement(By.xpath("//span[contains(.,'Transection Report')]"));
        Actions actions13 = new Actions(driver);
        actions13.keyDown(Keys.CONTROL).click(Transection_Report).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert7 = new SoftAssert();
        String Transection_Report_Page = driver.findElement(By.xpath("(//span[contains(.,'Transection Report')])[2]")).getText();
        softAssert7.assertTrue(Transection_Report_Page.contains("Transection Report"), "Transection Reports page assertion failed");
        softAssert7.assertAll();
        Thread.sleep(5000);
        System.out.println("TEST 20 Transection Report Page is OK !  " + Transection_Report_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        // Transactions_Reports_Tab // REPORT & ANALYTICS // Items Report
        WebElement Items_Report = driver.findElement(By.xpath("//span[contains(.,'Transection Report')]"));
        Actions actions14 = new Actions(driver);
        actions14.keyDown(Keys.CONTROL).click(Items_Report).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert8 = new SoftAssert();
        String Items_Report_Page = driver.findElement(By.xpath("//a[contains(@title,'Item Report')]")).getText();
        softAssert8.assertTrue(Items_Report_Page.contains("Item Report"), "Item Report page assertion failed");
        softAssert8.assertAll();
        Thread.sleep(5000);
        System.out.println("TEST 21 Item Report Page is OK !  " + Items_Report_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));


        // Transactions_Reports_Tab // REPORT & ANALYTICS // Store Wise Report
        WebElement Store_Wise_Report = driver.findElement(By.xpath("//span[contains(.,'Store Wise Report')]"));
        Actions actions15 = new Actions(driver);
        actions15.keyDown(Keys.CONTROL).click(Store_Wise_Report).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert9 = new SoftAssert();
        String Store_Wise_Report_Page = driver.findElement(By.xpath("//h1[contains(.,'Store Report')]")).getText();
        softAssert9.assertTrue(Store_Wise_Report_Page.contains("Store Report"), "Store Report page assertion failed");
        softAssert9.assertAll();
        Thread.sleep(5000);
        System.out.println("TEST 22 Store Wise Report Page is OK !  " + Store_Wise_Report_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        // Transactions_Reports_Tab // REPORT & ANALYTICS // Expense Report

        WebElement Expense_Report = driver.findElement(By.xpath("//a[contains(.,'Expense Report')]"));
        Actions actions16 = new Actions(driver);
        actions16.keyDown(Keys.CONTROL).click(Expense_Report).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert10 = new SoftAssert();
        String Expense_Report_Page = driver.findElement(By.xpath("(//span[contains(.,'Expense Report')])[2]")).getText();
        softAssert9.assertTrue(Expense_Report_Page.contains("Expense Report"), "Expense Report page assertion failed");
        softAssert9.assertAll();
        Thread.sleep(5000);
        System.out.println("TEST 23 Expense Report Page is OK !  " + Expense_Report_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));


        // Transactions_Reports_Tab // REPORT & ANALYTICS // Limited Stock Item

        WebElement Limited_Stock_Item = driver.findElement(By.xpath("//a[contains(.,'Limited Stock Item')]"));
        Actions actions17 = new Actions(driver);
        actions17.keyDown(Keys.CONTROL).click(Limited_Stock_Item).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert11 = new SoftAssert();
        String Limited_Stock_Item_Page = driver.findElement(By.xpath("//span[contains(.,'Low stock report')]")).getText();
        softAssert11.assertTrue(Limited_Stock_Item_Page.contains("Low Stock Report"), "Limited Stock Item page assertion failed");
        softAssert11.assertAll();
        Thread.sleep(5000);
        System.out.println("TEST 24 Limited Stock Item Page is OK !  " + Limited_Stock_Item_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));


        // Transactions_Reports_Tab // REPORT & ANALYTICS // Other Report

        WebElement Other_Report = driver.findElement(By.xpath("//span[contains(.,'Order Report')]"));
        Actions actions18 = new Actions(driver);
        actions18.keyDown(Keys.CONTROL).click(Other_Report).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        SoftAssert softAssert12 = new SoftAssert();
        String Other_Report_Page = driver.findElement(By.xpath("(//span[contains(.,'Order Report')])[2]")).getText();
        softAssert12.assertTrue(Other_Report_Page.contains("Order Report"), "Order Report page assertion failed");
        softAssert12.assertAll();
        Thread.sleep(5000);
        System.out.println("TEST 25 Order Report Page is OK !  " + Other_Report_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        return null;
    }


}
