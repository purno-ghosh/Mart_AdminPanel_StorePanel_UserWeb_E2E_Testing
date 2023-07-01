package React_Order_Place;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class React_website_Element {

    WebDriver driver;
   @FindBy(xpath = "//button[contains(.,'Accept')]")
   WebElement Cooke_Accept;

    @FindBy(css = "#__next > div.mui-style-6ovtiw > div:nth-child(2) > div.mui-style-rjxcs7 > div > div > div > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-3\\.9.MuiGrid-grid-sm-2\\.9.mui-style-1isx1jd > div > div > div > svg:nth-child(3)")
    WebElement Locate_me_button;

    @FindBy(xpath = "//p[contains(.,'Pick from map')]")
    WebElement PickMap_btn;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation mui-style-1igru4k'][contains(.,'Pick Locations')]")
    WebElement Pickloacation;
    public React_website_Element(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }

    public Object Order_Place() throws IOException, InterruptedException  {
        Thread.sleep(3000);
        Cooke_Accept.click();
      Thread.sleep(3000);
        Locate_me_button.click();
        Thread.sleep(3000);
        PickMap_btn.click();
        Thread.sleep(3000);
        Pickloacation.click();
        Thread.sleep(3000);
        return null;

    }

}
