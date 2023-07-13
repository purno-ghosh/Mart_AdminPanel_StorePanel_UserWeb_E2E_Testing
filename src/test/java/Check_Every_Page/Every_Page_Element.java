package Check_Every_Page;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public Every_Page_Element(WebDriver driver){
        this.driver=driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);


    }

    public String Admin_Users_All_Page(String email, String password) throws IOException, ParseException, InterruptedException{
        emailfld.sendKeys(email);
        passfld.sendKeys(password);
        logbtn.click();
        Thread.sleep(2000);
        Usertab.click();
        Thread.sleep(2000);
        String UserOverview = driver.findElement(By.xpath("//h1[@class='page-header-title mb-0'][contains(.,'User Overview')]")).getText();
        System.out.println("TEST 01 UserOverview Dashboard Is OK ! " + UserOverview);

        //DELIVERY MAN MANAGEMENT //Vehicles category Page Verify

        WebElement Vehicles_cat = driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate'][contains(.,'Vehicles category')]"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(Vehicles_cat).keyUp(Keys.CONTROL).perform();
        driver.switchTo().window(getNewTabHandle(driver));
        String Vehicle_Title = driver.findElement(By.xpath("//h1[@class='page-header-title'][contains(.,'Vehicles category list')]")).getText();
        System.out.println("TEST 02 Vehicles Category Is OK !  " + Vehicle_Title);
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
        System.out.println("TEST 03 DONE " + Add_Delivery_Man);
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
        System.out.println("TEST 04 DONE " + New_Delivery_Man);
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
        System.out.println("TEST 05 DONE " + Delivery_Man_lIst);
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
        System.out.println("TEST 06 DONE " + Reviews_page);
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
        System.out.println("TEST 07 DONE " + Customers_Page);
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
        Thread.sleep(2000);

        //CUSTOMER MANAGEMENT // Customers // Report

        driver.findElement(By.xpath("(//span[@class='text-truncate text-capitalize'][contains(.,'Report')])[1]")).click();
        Thread.sleep(2000);
        String Report_Page = driver.findElement(By.xpath("//span[contains(.,'Customer Wallet Report')]")).getText();
        System.out.println("TEST 08 DONE " + AddFund_Page + " Report " + Report_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));

        //CUSTOMER MANAGEMENT // Customers Loyalty Point

        driver.findElement(By.xpath("//span[@class='navbar-vertical-aside-mini-mode-hidden-elements text-truncate  text-capitalize'][contains(.,'Customer Loyalty Point')]")).click();
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
        System.out.println("TEST 09 DONE " + Loyalty_Page);
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
        System.out.println("TEST 10 DONE " + Subscribed_Page);
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
        System.out.println("TEST 11 DONE " + Messages_Page);
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
        System.out.println("TEST 12 DONE " + Employee_Role_Page);
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

        //CUSTOMER MANAGEMENT //Employees //Add New Employee // List

        driver.findElement(By.xpath("//a[@href='https://6ammart.sixamtech.com/dev/admin/users/employee/list']")).click();
        Thread.sleep(2000);
        String EmployeeList_Page = driver.findElement(By.xpath("//span[contains(.,'Employee List')]")).getText();
        System.out.println("TEST 13 DONE " + EmployeeList_Page);
        driver.close();
        driver.switchTo().window(getParentTabHandle(driver));




        return null;
    }


}
