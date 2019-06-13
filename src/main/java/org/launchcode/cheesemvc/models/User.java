package org.launchcode.cheesemvc.models;

public class User {
    private static int nextUserId = 0;
    private int userId;

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
    }

    private String userName;
    private String userEmail;
    private String userPassword;

    public User(String userName, String userEmail, String userPassword){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userId = User.getNextUserId();
    }

    public User(){
        this.userId = User.getNextUserId();
    }

    private static int getNextUserId(){
        int userId = nextUserId;
        nextUserId++;
        return userId;
    }
}
