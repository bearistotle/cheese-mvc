package org.launchcode.cheesemvc.models;

public class Cheese {
    private String name;
    private String description;

    public void Cheese(String name, String description){
        this.name = name;
        this.description = description;

    }

    public String getName(){
        return this.name;
    }

    public void setName(String aName){
        this.name = aName;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String aDescription){
        this.description = aDescription;
    }
}
