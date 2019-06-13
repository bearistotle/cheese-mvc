package org.launchcode.cheesemvc.models;

public enum CheeseType {

    //List of possible values; ("Name") essentially calls the constructor below and initializes the name field
    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Fake");

    private final String name;

    private CheeseType(String Name){
        this.name = Name;
    }

    public String getName(){
        return this.name;
    }


}
