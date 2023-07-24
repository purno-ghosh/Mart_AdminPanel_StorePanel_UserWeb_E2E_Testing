package Admin_Store_Setting_Store_Config;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;

public class Element_Admin_Store_Setting_Store_Config {
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

        // Locate the toggle button element using its XPath
        WebElement toggleButton = driver.findElement(By.xpath("//span[contains(.,'Include POS in store panel')]"));

// Get the value of the 'class' attribute
        String classAttributeValue = toggleButton.getAttribute("class");

        if (classAttributeValue.equals("toggle-switch-label")) {
            // If the class attribute value is "toggle-switch-label," the toggle button is OFF
            System.out.println("Include POS In Store Panel Toggle button is OFF");
        } else if (classAttributeValue.equals("toggle-switch-indicator")) {
            // If the class attribute value is "toggle-switch-indicator," the toggle button is ON
            System.out.println("Include POS In Store Panel Toggle button is ON");
        } else {
            // If the class attribute value is neither "toggle-switch-label" nor "toggle-switch-indicator," handle as needed
            System.out.println("Unable to determine the state of the toggle button");
        }




        return null;
    }

}
