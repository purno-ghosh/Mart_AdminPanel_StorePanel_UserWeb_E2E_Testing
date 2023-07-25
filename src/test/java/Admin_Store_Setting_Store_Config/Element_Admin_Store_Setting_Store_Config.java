package Admin_Store_Setting_Store_Config;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;

public class Element_Admin_Store_Setting_Store_Config {
    String Storemail="ecommerce.store7@demo.com";
    String Storepassword="12345678";
    WebDriver driver;
    @FindBy(xpath = "//input[@id='signinSrEmail']")
    WebElement emailfld;

    @FindBy(xpath = "//input[contains(@id,'signupSrPassword')]")
    WebElement passfld;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Login')]")
    WebElement logbtn;

    @FindBy(xpath = "//a[contains(.,'Users')]")
    WebElement Usertab;

    @FindBy(id = "datatableSearch_")
    WebElement SarchStore;

    @FindBy(xpath = "//div[@class='text--title'][contains(.,'Online Shopping')]")
    WebElement Online_Shopping_Store;
    @FindBy(xpath = "//a[@href='https://6ammart.sixamtech.com/dev/admin/store/view/24/settings']")
    WebElement Online_Shopping_Setting;

    public Element_Admin_Store_Setting_Store_Config(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }

    public String Manage_Item_Setup_Check(String email, String password) throws IOException, ParseException, InterruptedException {
        emailfld.sendKeys(email);
        passfld.sendKeys(password);
        logbtn.click();
        Thread.sleep(2000);
        Usertab.click();
        Thread.sleep(2000);

        WebElement modulesElement = driver.findElement(By.xpath("//a[contains(.,'Modules')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(modulesElement).perform();
        WebElement subElement = driver.findElement(By.xpath("//img[@src='https://6ammart.sixamtech.com/dev/storage/app/public/module/2022-04-24-6264c0169e405.png']"));
        subElement.click();
        WebElement StoreListButton = driver.findElement(By.xpath("(//span[contains(@class,'text-truncate')])[37]"));
        Thread.sleep(2000);
        // Scroll to the button element (optional)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", StoreListButton);
        js.executeScript("arguments[0].click();", StoreListButton);
        SarchStore.sendKeys(Storemail);
        SarchStore.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Online_Shopping_Store.click();
        Online_Shopping_Setting.click();


        WebElement Manage_Item_Setup = driver.findElement(By.id("item_section"));
        String checked_Manage_Item_Setup = Manage_Item_Setup.getAttribute("checked");

        if (checked_Manage_Item_Setup == null) {
            System.out.println("Manage Item Setup Toggle button is OFF");
            driver.quit();

            // Launch a new driver
            WebDriver StoreDriver = new ChromeDriver(); // or any other driver you are using
            StoreDriver.get("https://6ammart.sixamtech.com/dev/login/store");
            StoreDriver.findElement(By.id("signinSrEmail")).sendKeys(Storemail);
            StoreDriver.findElement(By.id("signupSrPassword")).sendKeys(password);
        }
        else {

            System.out.println("Manage Item Setup Toggle button is ON");
        }



        return null;
    }

}
