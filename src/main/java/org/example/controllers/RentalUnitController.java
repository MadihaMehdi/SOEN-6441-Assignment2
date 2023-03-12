package org.example.controllers;

import org.example.Database.RentalUnitRepository;
import org.example.Database.TenantRepository;
import org.example.models.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the rental units controller
 * which performs every operation
 * regarding the units
 */
public class RentalUnitController {
    private RentalUnitFactory factory;
    private AddressFactory adFactory;

    Observer observer;
    Scanner input = new Scanner(System.in);

    RentalUnitRepository repository;

    TenantRepository tenantRepository;

    /**
     * Constructor
     */
    public RentalUnitController(RentalUnitRepository obj, TenantRepository tenantRepository){
        repository = obj;
        factory = new RentalUnitFactory();
        adFactory = new AddressFactory();
        observer = new Observer();
        this.tenantRepository = tenantRepository;
    }

    /**
     * create a unit and
     * store it in the database
     */
    public void createRentalUnit (){
        try {
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
            System.out.println("Rental unit has been created");
            System.out.println(obj);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }

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
    public String changeRent(){
        System.out.println("Please enter the ID of the rental unit");
        int Id = input.nextInt();
        System.out.println("Please Enter the state of the rental unit");
        boolean outcome = false;
        if(input.nextLine().equals("rent"))
            outcome = repository.update(Id,true);
        else if(input.nextLine().equals("vacant")) {
            outcome = repository.update(Id, false);
            ArrayList<String> list = observer.getRegistered();
            for(String a: list){
                String []parts = a.split(" ");
                if(Integer.parseInt(parts[1]) == Id)
                    observer.send(Id);
            }
        }

        if(outcome)
            return ("The type of RentalUnit is changed");
        else
            return ("We can't change the type at the moment");
    }

    /**
     * display all the units in the database
     */
    public void displayAllUnits(){
        try {
            for (RentalUnit r : repository.getAll())
                System.out.println(r);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }

    }

    /**
     * display all the rented units in the database
     */
    public void displayRentedUnits(){
        try {
            for (RentalUnit r : repository.getAllRented())
                System.out.println(r);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }

    }

    /**
     * display all the vacant units in the database
     */
    public void vacantUnits(){
        try {
            for (RentalUnit r : repository.getAllVacant())
                System.out.println(r);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }

    }

    /**
     * Register the tenants that
     * want to check if a unit became vacant or not
     */
    public void RegisterTenant(){
        try {
            System.out.println("Please enter the ID of the rental unit you want to observe");
            RentalUnit obj = repository.getUnit(input.nextInt());
            System.out.println("Please enter your name");
            Tenant tenant = tenantRepository.get(input.next());
            observer.subscribe(tenant, obj);
        }
        catch (Exception e){
            System.out.println("It seems something went wrong");
        }
    }


}
