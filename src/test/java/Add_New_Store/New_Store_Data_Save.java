package Add_New_Store;

public class New_Store_Data_Save {

    private String storeName;
    private String firstName;
    private String lastName;
    private String email2;
    private String phoneNumber;

    public New_Store_Data_Save(String storeName, String firstName, String lastName, String email2, String phoneNumber) {
        this.storeName = storeName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email2 = email2;
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

    public String getEmail() {
        return email2;
    }

    public void setEmail(String email2) {
        this.email2 = email2;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

