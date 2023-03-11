package org.example.controllers;

import org.example.Database.RentalUnitRepository;
import org.example.models.AddressFactory;
import org.example.models.RentalUnit;
import org.example.models.RentalUnitFactory;
import org.example.models.Tenant;

import java.util.ArrayList;
import java.util.Scanner;


public class RentalUnitController {
    private RentalUnitFactory factory;
    private AddressFactory adFactory;
    Scanner input = new Scanner(System.in);

    RentalUnitRepository repository;

    public RentalUnitController(RentalUnitRepository obj){
        repository = obj;
        factory = new RentalUnitFactory();
        adFactory = new AddressFactory();
    }

    public void createRentalUnit (){
        RentalUnit obj = null;
        System.out.println("Please enter the type of rental unit you want to create");
        obj = factory.getInstance(input.nextLine());
        obj.setAddress(adFactory.getInstance(input.nextLine()));
        obj.getAddress().BuildAddress();
        System.out.println("Please Enter the number of bedrooms");
        obj.setBedrooms(input.nextInt());
        System.out.println("Please Enter the number of bathrooms");
        obj.setBathrooms(input.nextInt());
        System.out.println("Please Enter the area");
        obj.setArea(input.nextInt());
        obj.setRented(false);
        repository.save(obj);
    }
    public RentalUnit getRentalUnit(int Id){
        return repository.get(Id);
    }


    public void removeRentalUnit(int Id){
        RentalUnit obj = getRentalUnit(Id);
        if(repository.delete(obj))
            System.out.println("The unit has been deleted");
        else
            System.out.println("It seems there is no unit with this ID");
    }
    public void changeRent(int Id){
        System.out.println("Please Enter the state of the rental unit");
        String type = input.nextLine();
        boolean outcome = false;
        if(type.equals("rent"))
            outcome = repository.update(Id,true);
        else if(type.equals("vacant"))
            outcome = repository.update(Id, false);

        if(outcome)
            System.out.println("The type of RentalUnit is changed");
        else
            System.out.println("We can't change the type at the moment");

    }
    public void rentedUnits(){
        repository.getAllRented();
    }
    public void vacantUnits(){
        repository.getAllVacant();
    }


}
