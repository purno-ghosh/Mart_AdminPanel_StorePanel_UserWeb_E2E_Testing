package Add_New_Store;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store_Element {

    private static List<New_Store_Data_Save> readDataFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("./src/test/resources/All_json_File/Store_Saved_Data.json");

        try {
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<New_Store_Data_Save>>() {
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(); // Return an empty list if there is an error
    }

    private static void saveDataToFile(List<New_Store_Data_Save> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("./src/test/resources/All_json_File/Store_Saved_Data.json");
        try (FileWriter fileWriter = new FileWriter(file)) {
            objectMapper.writeValue(fileWriter, data);
            System.out.println("New Store data saved to Store_Saved_Data.json");
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
    @FindBy(xpath = "//span[contains(.,'Coupons')]")
    WebElement Coupon_Btn;
    @FindBy(xpath = "//span[contains(.,'Add new restaurant')]")
    WebElement NewStore_btn;
    @FindBy(xpath = "//input[@id='default_name']")
    WebElement Restaurant_Name;

    @FindBy(xpath = "(//textarea[contains(@type,'text')])[1]")
    WebElement Store_Adress;
    @FindBy(xpath = "//input[@name='tax']")
    WebElement Tax_Field;

    @FindBy(xpath = "//a[contains(@class,'floating-date-toggler')]")
    WebElement Estimate_Field;

    @FindBy(xpath = "//input[contains(@id,'minimum_delivery_time')]")
    WebElement Esti_minmuin;

    @FindBy(xpath = "//input[contains(@id,'maximum_delivery_time')]")
    WebElement Esti_maximum;

    @FindBy(id = "pac-input")
    WebElement Zone_Data;

    @FindBy(xpath = "//input[contains(@name,'f_name')]")
    WebElement StFirstName;

    @FindBy(xpath = "//input[contains(@name,'l_name')]")
    WebElement StlastName;

    @FindBy(id = "phone")
    WebElement Stphonenum;

    @FindBy(xpath = "//input[contains(@type,'email')]")
    WebElement Stemail;

    @FindBy(id = "signupSrPassword")
    WebElement StPassword;

    @FindBy(id = "signupSrConfirmPassword")
    WebElement StConfirmpass;

    @FindBy(id = "datatableSearch_")
    WebElement SarchStore;

    // New store login

    @FindBy(id = "signinSrEmail")
    WebElement StoreEmail;

    @FindBy(id = "signupSrPassword")
    WebElement StorePass;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'login')]")
    WebElement StoreLoginBtn;

    @FindBy(xpath = "//span[contains(.,'Items')]")
    WebElement Itembtn;

    @FindBy(xpath = "(//span[@class='text-truncate'][contains(.,'Add New')])[1]")
    WebElement Addnewbtn;

    @FindBy(id = "default_name")
    WebElement NewItemNameFld;

    @FindBy(xpath = "(//textarea[contains(@name,'description[]')])[1]")
    WebElement NewItemDescriptionFld;

    @FindBy(xpath = "//input[contains(@name,'price')]")
    WebElement SelectPrice;
    @FindBy(xpath = "//button[@type='submit'][contains(.,'Submit')]")
    WebElement SubmitBtn;

    public Store_Element(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }

    public String Create_New_Store(String email, String password) throws InterruptedException {
        emailfld.sendKeys(email);
        passfld.sendKeys(password);
        logbtn.click();
        Thread.sleep(2000);
        Usertab.click();
        Thread.sleep(2000);
        WebElement modulesElement = driver.findElement(By.xpath("//a[contains(.,'Modules')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(modulesElement).perform();
        // Perform other actions after the mouse hover, such as clicking on a sub-element
        WebElement subElement = driver.findElement(By.xpath("//img[@src='https://6ammart.sixamtech.com/dev/storage/app/public/module/2022-04-24-6264c16647b39.png']"));
        subElement.click();
        Thread.sleep(2000);
        Coupon_Btn.click();
        Thread.sleep(2000);
        NewStore_btn.click();

        Random random = new Random();
        String storeName = "StoreTest" + random.nextInt(1000);
        String firstName = "SrtTest" + random.nextInt(1000);
        String lastName = "Last" + random.nextInt(1000);
        String storEmail = "SrtTest" + random.nextInt(10000) + "@example.com";
        String phoneNumber = "160000" + String.format("%04d", random.nextInt(10000));

        // Create a new StoreData object
        New_Store_Data_Save storeData = new New_Store_Data_Save(storeName, firstName, lastName, storEmail, phoneNumber);
        // Read existing data from JSON file, if any
        List<New_Store_Data_Save> existingData = readDataFromFile();
        // Add new storeData to the existingData list
        existingData.add(storeData);
        // Save the updated list to JSON file
        saveDataToFile(existingData);
        Restaurant_Name.sendKeys(storeName);
        Store_Adress.sendKeys("Mirpur 10 6am Tech");


        // Home PC  C:\Users\\user\Desktop\New CV 24-03-2022\TestingIMG.png
        //code update from office 04-07-2023 10:05 AM

        WebElement UploadImg = driver.findElement(By.xpath("//input[@type='file']"));
        UploadImg.sendKeys("C:\\Users\\Lenovo\\Desktop\\Product_images\\Food\\Food_1.png");
        Tax_Field.sendKeys("10");
        Thread.sleep(2000);
        Estimate_Field.click();
        Thread.sleep(3000);
        Esti_minmuin.sendKeys("10");
        Esti_maximum.sendKeys("20");

        WebElement Donebutton = driver.findElement(By.xpath("//button[contains(.,'Done')]"));

        // Scroll to the button element (optional)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", Donebutton);
        js.executeScript("arguments[0].click();", Donebutton);
        Thread.sleep(2000);

        Select select = new Select(driver.findElement(By.xpath("//select[contains(@name,'zone_id')]")));
        select.selectByVisibleText("Main Demo Zone");
        Thread.sleep(2000);
        Zone_Data.sendKeys("Mirpur");
        Zone_Data.sendKeys(Keys.ENTER);

        StFirstName.sendKeys(firstName);
        StlastName.sendKeys(lastName);
        Stphonenum.sendKeys(phoneNumber);
        Stemail.sendKeys(storEmail);
        Thread.sleep(2000);
        StPassword.sendKeys("Pg@123456");
        Thread.sleep(2000);
        StConfirmpass.sendKeys("Pg@123456");
        // Find the button element
        WebElement button = driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Submit')]"));

        // Scroll to the button element (optional)
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView(true);", button);
        js2.executeScript("arguments[0].click();", button);
        System.out.println("Store Name :: " + storeName);
        System.out.println("Store First Name :: " + firstName);
        System.out.println("Store Last Name :: " + lastName);
        System.out.println("Store Email :: " + storEmail);
        SarchStore.sendKeys(storeName);
        SarchStore.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        // Wait for the table to load and locate the row containing the user
        WebElement storeRow = driver.findElement(By.xpath("//div[@class='text--title'][contains(.,'" + storeName + "')]"));
        storeRow.getText();
        // Assert that the newly created delivery manis displayed
        assert storeRow.isDisplayed() : "The Store row is not displayed in the table.";
        System.out.println(storeRow);
        return null;

    }
    public String Login_New_Store(String storEmail) throws InterruptedException {
        StoreEmail.sendKeys(storEmail);
        StorePass.sendKeys("Pg@123456");
        StoreLoginBtn.click();
        System.out.println(" New Store Login With " + storEmail);
        Itembtn.click();
        Addnewbtn.click();
        NewItemNameFld.sendKeys("KFC Burger");
        NewItemDescriptionFld.sendKeys("The KFC is the Best Restaurant");
        Thread.sleep(2000);
        WebElement UploadImg1 = driver.findElement(By.xpath("//input[@type='file']"));
        UploadImg1.sendKeys("C:\\Users\\Lenovo\\Desktop\\Product_images\\Food\\Food_1.png");
        Thread.sleep(3000);
        WebElement UploadImg2 = driver.findElement(By.id("customFileEg1"));
        UploadImg2.sendKeys("C:\\Users\\Lenovo\\Desktop\\Product_images\\Food\\Food_1.png");
        Select selectCatagory = new Select(driver.findElement(By.id("category_id")));
        selectCatagory.selectByVisibleText("Burger");
        Thread.sleep(3000);
        SelectPrice.clear();
        SelectPrice.sendKeys("100");
        Thread.sleep(3000);
        WebElement time_input = driver.findElement(By.name("available_time_starts"));
        time_input.clear();
        time_input.sendKeys("12:30 AM");
        time_input.sendKeys(Keys.ENTER);
        WebElement time_input1 = driver.findElement(By.name("available_time_ends"));
        time_input1.clear();
        time_input1.sendKeys("12:30 AM");
        time_input1.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        SubmitBtn.click();
        return null;
    }

}

