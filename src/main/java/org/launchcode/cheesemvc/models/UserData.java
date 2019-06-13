package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class UserData {
    private static ArrayList<User> users = new ArrayList<>();

    public static void add(User user){
        users.add(user);
    }

    public static ArrayList<User> getAll(){
        return users;
    }

    public static User getById(int id){
        User user = new User();

        for (User candidateUser : users){
            if (candidateUser.getUserId() == id){
                user = candidateUser;
            }
        }

        return user;
    }
}
