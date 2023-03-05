package org.example.models;

public class RentalUnitFactory {
    public  RentalUnit getInstance(String type){
        if(type.equals("apartment"))
            return new Appartment();
        else if(type.equals("house"))
            return new House();
        return null;
    }
}
