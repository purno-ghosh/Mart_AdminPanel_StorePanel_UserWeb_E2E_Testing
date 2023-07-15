package Setup_Page;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void takeScreenShot() throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, DestFile);

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStorEmail() {
        return storEmail;
    }

    public void setStorEmail(String storEmail) {
        this.storEmail = storEmail;
    }

    public String email;
    public String password;
    public String storEmail;

    public void readJSONArray(int pos) throws IOException, ParseException, ParseException {
        String fileName = "./src/test/resources/All_json_File/login_credentials.json";
        org.json.simple.parser.JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonObj = (JSONObject) jsonArray.get(pos);
        setEmail((String) jsonObj.get("email"));
        setPassword((String) jsonObj.get("password"));

    }

    public void readJSONArrayStore(int pos) throws IOException, ParseException, ParseException {
        String fileName = "./src/test/resources/All_json_File/Store_Saved_Data.json";
        org.json.simple.parser.JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonObj = (JSONObject) jsonArray.get(pos);
        setStorEmail((String) jsonObj.get("storEmail"));


    }

}
