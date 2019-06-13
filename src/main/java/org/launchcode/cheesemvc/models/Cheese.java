package org.launchcode.cheesemvc.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {
    @NotNull
    @Size(min=3, max=25)
    private String name;
    @NotNull
    @Size(min=1, message="Description must not be empty.")
    private String description;
    private CheeseType type;
    private int rating;
    private int cheeseId;
    private static int nextCheeseId = 0;

    public Cheese(String name, String description, CheeseType type, int rating){
        //call default constructor (to ensure full initialization)
        this();
        this.name = name;
        this.description = description;
        this.type = type;
        this.rating = rating;

    }

    //default constructor
    public Cheese(){
        this.cheeseId = Cheese.getNextCheeseID();
    }

    public static int getNextCheeseID(){
        int cheeseId = nextCheeseId;
        nextCheeseId++;
        return cheeseId;
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

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
