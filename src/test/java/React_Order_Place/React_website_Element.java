package React_Order_Place;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class React_website_Element {

    WebDriver driver;


    @FindBy(id = ":r1:-Locate-me")
    WebElement Locate_me_button;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div[2]/div/button[2]")
    WebElement Location_permissing;

    @FindBy(xpath = "//button[contains(.,'Accept')]")
    WebElement Cooke_Accept;



    @FindBy(css = "#\\:r2\\:")
    WebElement Location_Search_field;

    @FindBy(xpath = "//p[contains(.,'Explore')]")
    WebElement Explore_btn;

    public React_website_Element(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }

    public Object Order_Place() throws IOException, InterruptedException {

//        Locate_me_button.click();
//        Thread.sleep(3000);
//        Location_permissing.click();
//        Thread.sleep(3000);
        Cooke_Accept.click();
        Thread.sleep(3000);
        Location_Search_field.sendKeys("4B Kemal Ataturk Ave, Dhaka 1212, Bangladesh");
        Explore_btn.click();
//        PickMap_btn.click();
//        Thread.sleep(3000);
//        Pickloacation.click();
//        Thread.sleep(3000);
        return null;

    }

}
