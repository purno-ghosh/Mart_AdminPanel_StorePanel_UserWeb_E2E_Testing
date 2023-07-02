package Add_New_Store;

public class New_Store_Data_Save {

    private String storeName;
    private String firstName;
    private String lastName;
    private String storEmail;
    private String phoneNumber;

    public New_Store_Data_Save(String storeName, String firstName, String lastName, String storEmail, String phoneNumber) {
        this.storeName = storeName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.storEmail = storEmail;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getStorEmail() {
        return storEmail;
    }

    public void setStorEmail(String storEmail) {
        this.storEmail = storEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

