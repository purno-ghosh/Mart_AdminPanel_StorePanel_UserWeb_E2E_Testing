package Add_Delivery_Man;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Delivery_Man_Adding_Element {
    private static List<Delivery_Man_User_Data_Save> readDataFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("./src/test/resources/All_json_File/NewDeliver_data.json");

        try {
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Delivery_Man_User_Data_Save>>() {
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(); // Return an empty list if there is an error
    }
    private static void saveDataToFile(List<Delivery_Man_User_Data_Save> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("./src/test/resources/All_json_File/NewDeliver_data.json");
        try (FileWriter fileWriter = new FileWriter(file)) {
            objectMapper.writeValue(fileWriter, data);
            System.out.println("New Delivery man data saved to NewDeliver_data.json\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        Delivery_Man_User_Data_Save userData= new Delivery_Man_User_Data_Save(firstName, lastName, email2, phoneNumber);
        // Read existing data from JSON file, if any
        List<Delivery_Man_User_Data_Save> existingData = readDataFromFile();
        // Add new storeData to the existingData list
        existingData.add(userData);
        // Save the updated list to JSON file
        saveDataToFile(existingData);

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email2);
        phoneNumberInput.sendKeys(phoneNumber);
        System.out.println("Delivery man First "+firstName);
        System.out.println("Delivery man Last Name "+lastName);
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

        // Wait for the table to load and locate the row containing the user
        WebElement userRow = driver.findElement(By.xpath("//h5[@class='text-hover-primary mb-0'][contains(.,'" + K + "')]"));
       userRow.getText();
       // Assert that the newly created delivery manis displayed
        assert userRow.isDisplayed() : "The user row is not displayed in the table.";
        System.out.println(userRow);
        return null;

    }
}
