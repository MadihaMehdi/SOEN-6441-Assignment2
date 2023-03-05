package org.example.models;

public class AddressFactory {
    public Address getInstance (String type){
        if(type.equals("apartment"))
            return new ApartmentAddress();
        else if(type.equals("house"))
            return new HouseAddress();
        return null;
    }
}
