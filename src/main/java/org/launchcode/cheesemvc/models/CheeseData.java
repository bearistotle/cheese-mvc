package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {
    static ArrayList<Cheese> cheeses = new ArrayList<>();

    //get method
    public static ArrayList<Cheese> getAll(){
        return cheeses;
    }
    //add method
    public static void add(Cheese newCheese){
        cheeses.add(newCheese);
    }

    //remove method
    public static void remove(int id){
        Cheese cheeseToRemove = getByID(id);
        cheeses.remove(cheeseToRemove);
    }
    //get by id method
    public static Cheese getByID(int cheeseId){
        Cheese cheese = new Cheese();
        for (Cheese candidateCheese : cheeses){
            if (candidateCheese.getCheeseId() == cheeseId) {
                cheese = candidateCheese;
            }
        }
        return cheese;
    }
}
