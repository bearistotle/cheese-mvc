package org.launchcode.cheesemvc.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    private static int nextUserId = 0;
    private int userId;
    @NotNull
    @Size(min=5, max=15, message="Username must be between 5--15 characters.")
    private String userName;
    @Email
    private String userEmail;
    @NotNull
    @Size(min=6, message="Password must be at least 6 characters.")
    private String userPassword;
    @NotNull(message="Passwords do not match.")
    private String verifyPassword;


    public User(String userName, String userEmail, String userPassword){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userId = User.getNextUserId();
    }

    public User(){
        this.userId = User.getNextUserId();
    }


    private void checkPassword(){
        if (!this.getUserPassword().isEmpty() && !this.getVerifyPassword().isEmpty()){
            if (!this.getUserPassword().equals(getVerifyPassword())){
                verifyPassword = null;
            }
        }
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        this.checkPassword();
    }

    private static int getNextUserId(){
        int userId = nextUserId;
        nextUserId++;
        return userId;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        this.checkPassword();
    }
}
