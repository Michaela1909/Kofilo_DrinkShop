package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class user {
    private SimpleIntegerProperty UserID;
    private SimpleStringProperty username;
    private SimpleStringProperty fullName;
    private SimpleStringProperty email;
    private SimpleStringProperty phone;
    private SimpleStringProperty password;
    private SimpleStringProperty repassword;
    private SimpleIntegerProperty userStatus;

    public user (int UserID, String username, String fullName, String email, String phone, String password, String repassword, int userStatus) {
        this.UserID = new SimpleIntegerProperty(UserID);
        this.username = new SimpleStringProperty(username);
        this.fullName = new SimpleStringProperty(fullName);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.password = new SimpleStringProperty(password);
        this.repassword = new SimpleStringProperty(repassword);
        this.userStatus = new SimpleIntegerProperty(userStatus);
    }

    public int getUserID() {
        return UserID.get();
    }

    public void setUserID(int UserID) {
        this.UserID.set(UserID);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getRepassword() {
        return repassword.get();
    }

    public void setRepassword(String repassword) {
        this.repassword.set(repassword);
    }

    public int getUserStatus() {
        return userStatus.get();
    }

    public void setUserStatus(int userStatus) {
        this.userStatus.set(userStatus);
    }
}