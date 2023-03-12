package org.example.controllers;

import org.example.Database.RentalUnitRepository;
import org.example.models.AddressFactory;
import org.example.models.RentalUnit;
import org.example.models.RentalUnitFactory;
import java.util.Scanner;

/**
 * This is the rental units controller
 * which performs every operation
 * regarding the units
 */
public class RentalUnitController {
    private RentalUnitFactory factory;
    private AddressFactory adFactory;
    Scanner input = new Scanner(System.in);

    RentalUnitRepository repository;

    /**
     * Constructor
     */
    public RentalUnitController(RentalUnitRepository obj){
        repository = obj;
        factory = new RentalUnitFactory();
        adFactory = new AddressFactory();
    }

    /**
     * create a unit and
     * store it in the database
     */
    public void createRentalUnit (){
        RentalUnit obj = null;
        System.out.println("Please enter the type of rental unit you want to create");
        String type = input.nextLine();
        obj = factory.getInstance(type);
        obj.setAddress(adFactory.getInstance(type));
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

    /**
     * @return  a unit
     * from the database by
     * searching its ID
     */
    public RentalUnit getRentalUnit(int Id){
        return repository.get(Id);
    }

    /**
     * @return a string indicating if
     * a unit has been deleted or not
     */
    public String removeRentalUnit(int Id){
        RentalUnit obj = getRentalUnit(Id);
        if(repository.delete(obj))
            return ("The unit has been deleted");
        else
            return ("It seems there is no unit with this ID");
    }

    /**
     * @return a string indicating if
     * a unit rented property has been
     * changed or not
     */
    public String changeRent(int Id){
        System.out.println("Please Enter the state of the rental unit");
        boolean outcome = false;
        if(input.equals("rent"))
            outcome = repository.update(Id,true);
        else if(input.equals("vacant"))
            outcome = repository.update(Id, false);

        if(outcome)
            return ("The type of RentalUnit is changed");
        else
            return ("We can't change the type at the moment");
    }

    /**
     * display all the units in the database
     */
    public void displayAllUnits(){
        for(RentalUnit r: repository.getAll())
            System.out.println(r);
    }

    /**
     * display all the rented units in the database
     */
    public void displayRentedUnits(){
        for(RentalUnit r: repository.getAllRented())
            System.out.println(r);
    }

    /**
     * display all the vacant units in the database
     */
    public void vacantUnits(){
        for(RentalUnit r: repository.getAllVacant())
            System.out.println(r);
    }


}
