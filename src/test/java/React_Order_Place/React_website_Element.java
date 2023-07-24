package React_Order_Place;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
public class React_website_Element {

    WebDriver driver;
    @FindBy(xpath = "//button[contains(.,'Accept')]")
    WebElement Cooke_Accept;
    @FindBy(id = ":r1:-Locate-me")
    WebElement Locate_me_button;
    @FindBy(id = ":r1:-pick-from-map")
    WebElement Pick_From_Map;
    @FindBy(xpath = "(//img[contains(@alt,'mobile')])[1]")
    WebElement Grocery_Module;

    @FindBy(xpath = "(//div[contains(.,'Sign In')])[9]")
    WebElement Sign_in;
    @FindBy(xpath = "//input[contains(@placeholder,'Enter phone number')]")
    WebElement Phone_Number;
    @FindBy(xpath = "//input[contains(@name,'password')]")
    WebElement React_Password;
    @FindBy(xpath = "(//button[contains(.,'Sign In')])[2]")
    WebElement Login_Singnin;
    @FindBy(xpath = "//input[contains(@placeholder,'Search for items or store...')]")
    WebElement Search_Field;

    @FindBy(xpath = "//button[contains(.,'Buy Now')]")
    WebElement Buy_Now;

    @FindBy(xpath = "(//input[contains(@class,'PrivateSwitchBase-input mui-style-1m9pwf3')])[8]")
    WebElement CheckBox_Button;

    @FindBy(xpath = "//button[contains(.,'Place Order')]")
    WebElement Place_Order;

    public React_website_Element(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }

    public Object Login_React_Website() throws IOException, InterruptedException {

        Cooke_Accept.click();
        Thread.sleep(3000);
        Locate_me_button.click();
        Thread.sleep(3000);
        Pick_From_Map.click();
        WebElement Pick_Locations = driver.findElement(By.xpath("//button[contains(.,'Pick Locations')]"));
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
        wait.until(ExpectedConditions.elementToBeClickable(Pick_Locations));
        Pick_Locations.click();
        Thread.sleep(2000);
        Grocery_Module.click();
        Thread.sleep(2000);
        Sign_in.click();
        Phone_Number.clear();
        Phone_Number.sendKeys("1627272727");
        Thread.sleep(2000);
        React_Password.sendKeys("Pg@123456");
        Login_Singnin.click();
        Thread.sleep(5000);
        Search_Field.sendKeys("Suruchi Premium Green Chili Pickle");
        Search_Field.sendKeys(Keys.ENTER);
        WebElement Product_Click = driver.findElement(By.xpath("//h6[contains(.,'Suruchi Premium Green Chili Pickle')]"));
        WebDriverWait wait1 = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
        wait1.until(ExpectedConditions.elementToBeClickable(Product_Click));
        Product_Click.click();
        Buy_Now.click();
        Thread.sleep(2000);
        CheckBox_Button.click();
        Thread.sleep(2000);
        Place_Order.click();

        return null;

    }

}
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        int scrollHeight = Integer.parseInt(jsExecutor.executeScript("return Math.max( document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight );").toString());
//
//        // Define the scroll speed and the total duration of the scrolling action
//        int scrollSpeed = 20; // Adjust this value to control the scrolling speed (milliseconds)
//        int duration = 40000; // Adjust this value to control the total duration of scrolling (milliseconds)
//
//        long startTime = System.currentTimeMillis();
//        long currentTime = System.currentTimeMillis();
//
//        while (currentTime - startTime < duration) {
//            jsExecutor.executeScript("window.scrollBy(0, 1)");
//            try {
//                Thread.sleep(scrollSpeed);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            currentTime = System.currentTimeMillis();
//        }