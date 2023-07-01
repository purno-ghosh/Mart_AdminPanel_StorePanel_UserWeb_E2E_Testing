package Add_Delivery_Man;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Delivery_Man_Adding_Element {

    WebDriver driver;


    @FindBy(xpath = "//input[@id='signinSrEmail']")
    WebElement emailfld;

    @FindBy(xpath = "//input[contains(@id,'signupSrPassword')]")
    WebElement passfld;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'login')]")
    WebElement logbtn;

    @FindBy(xpath = "//a[contains(.,'Users')]")
    WebElement Usertab;
    @FindBy(xpath = "//a[@href='https://6ammart.sixamtech.com/dev/admin/users/delivery-man/add']")
    WebElement AddDeliveryBtn;

    @FindBy(xpath = "//input[contains(@name,'f_name')]")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[contains(@name,'l_name')]")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[contains(@type,'email')]")
    WebElement emailInput;

    @FindBy(xpath = "//input[contains(@id,'phone')]")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//select[contains(@name,'earning')]")
    WebElement earningSelect;

    @FindBy(xpath = "(//select[contains(@name,'id')])[1]")
    WebElement idSelect;

    @FindBy(xpath = "//span[@class='select2-selection__placeholder'][contains(.,'Select Vehicle')]")
    WebElement selectVehiclePlaceholder;

    @FindBy(xpath = "//input[contains(@class,'select2-search__field')]")
    WebElement selectVehicleInput;

    @FindBy(xpath = "//input[@type='file']")
    WebElement fileInput;

    @FindBy(xpath = "//input[contains(@name,'identity_number')]")
    WebElement identityNumberInput;

    @FindBy(xpath = "//input[contains(@id,'signupSrPassword')]")
    WebElement passwordInput;

    @FindBy(xpath = "//input[contains(@id,'signupSrConfirmPassword')]")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[contains(.,'Submit')]")
    WebElement submitButton;

    @FindBy(xpath = "//input[contains(@id,'datatableSearch_')]")
    WebElement searchInput;

    @FindBy(xpath = "(//i[contains(@class,'tio-visible-outlined')])[1]")

    WebElement eyebtn;

    public Delivery_Man_Adding_Element(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }

    public String Delivery_Man_Create(String email, String password) throws IOException, ParseException, InterruptedException {
        emailfld.sendKeys(email);
        passfld.sendKeys(password);
        logbtn.click();
        Thread.sleep(2000);
        Usertab.click();
        Thread.sleep(2000);
        AddDeliveryBtn.click();
        Random random = new Random();
        String firstName = "Test" + random.nextInt(1000); // Random number appended to "Test"
        String lastName = "Last" + random.nextInt(1000); // Random number appended to "Last"
        String email2 = "test" + random.nextInt(10000) + "@example.com";
        String phoneNumber = "160000" + String.format("%04d", random.nextInt(10000));// Random 4-digit number appended to "123456"

        // Save random values to JSON
        Delivery_Man_User_Data_Save userData = new Delivery_Man_User_Data_Save(firstName, lastName, email2, phoneNumber);
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = "./src/test/resources/NewDeliver_data.json";
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write("\n");
            objectMapper.writeValue(fileWriter, userData);
            System.out.println("User data saved to user_data.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email2);
        phoneNumberInput.sendKeys(phoneNumber);
        System.out.println(firstName);
        System.out.println(lastName);
        String K = firstName + " " + lastName;
        System.out.println(K);

        Select sel1 = new Select(earningSelect);
        sel1.selectByValue("0");
        Thread.sleep(2000);
        Select sel2 = new Select(idSelect);
        sel2.selectByValue("1");
        Thread.sleep(2000);

        selectVehiclePlaceholder.click();
        selectVehicleInput.sendKeys("Bicycle");
        selectVehicleInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        fileInput.sendKeys("C:\\Users\\Lenovo\\Desktop\\Product_images\\Deliverman\\Delivarmanpic.png");
        identityNumberInput.sendKeys("123456");
        Thread.sleep(2000);
        passwordInput.sendKeys("Pg@123456");
        confirmPasswordInput.sendKeys("Pg@123456");
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(3000);
        Thread.sleep(3000);
        searchInput.sendKeys(K);
        Thread.sleep(3000);
        searchInput.sendKeys(Keys.ENTER);
//        searchInput.clear();
//        eyebtn.click();
//        Thread.sleep(2000);

        return null;

    }
}
