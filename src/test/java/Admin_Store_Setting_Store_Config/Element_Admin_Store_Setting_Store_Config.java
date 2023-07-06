package Admin_Store_Setting_Store_Config;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Element_Admin_Store_Setting_Store_Config {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='signinSrEmail']")
    WebElement emailfld;

    @FindBy(xpath = "//input[contains(@id,'signupSrPassword')]")
    WebElement passfld;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'login')]")
    WebElement logbtn;

    @FindBy(xpath = "//a[contains(.,'Users')]")
    WebElement Usertab;

    @FindBy(id = "datatableSearch_")
    WebElement SarchStore;

    @FindBy(xpath = "//div[@class='text--title'][contains(.,'Online Shopping')]")
    WebElement Online_Shopping_Store;
    @FindBy(xpath = "//a[@href='https://6ammart.sixamtech.com/dev/admin/store/view/24/settings']")
    WebElement Online_Shopping_Setting;

    // (//span[@class='toggle-switch-label'])[4]
// @FindBy(xpath = "//span[@class='pr-2'][contains(.,'Home delivery')]")
//    @FindBy(xpath = "//span[@class='toggle-switch-label'])[4]")
//    WebElement Home_delivery_onOff_Toggle;
    public Element_Admin_Store_Setting_Store_Config(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }

    public String Admin_Home_Delivery_ON(String email, String password) throws IOException, ParseException, InterruptedException {
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
        SarchStore.sendKeys("ecommerce.store7@demo.com");
        SarchStore.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Online_Shopping_Store.click();
        Online_Shopping_Setting.click();
//        Home_delivery_onOff_Toggle.click();

//// Wait for the toggle button to be clickable (if needed)
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#vendor > div > div.card-body > div:nth-child(1) > div:nth-child(6) > div > label > span.toggle-switch-label")));
//
//// Get the class attribute of the toggle button
//        String classAttribute = toggleButton.getAttribute("class");
//
//// Print the class attribute for debugging
//        System.out.println("Class attribute: " + classAttribute);
//
//// Check if the toggle button is "on" or "off" based on its class attribute
//        boolean isToggleButtonOn = classAttribute.contains("active");
//
//// Print the state of the toggle button
//        System.out.println("Toggle button is " + (isToggleButtonOn ? "ON" : "OFF"));


        WebElement toggleButton = driver.findElement(By.xpath("(//span[contains(@class,'toggle-switch-label')])[6]"));
        String ariaDisabledValue = toggleButton.getAttribute("aria-disabled");
        boolean isToggleButtonOn = !(ariaDisabledValue != null && ariaDisabledValue.equals("true"));
        System.out.println("Toggle button is " + (isToggleButtonOn ? "ON" : "OFF"));



        return null;
    }

}
