package org.example.controllers;

import org.example.Database.LeaseRepository;
import org.example.Database.RentalUnitRepository;
import org.example.Database.TenantRepository;
import org.example.models.Lease;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LeaseController {
    TenantRepository tenantRepository;
    RentalUnitRepository rentalUnitRepository;
    LeaseRepository leaseRepository;
    Scanner input = new Scanner(System.in);

    public LeaseController(TenantRepository tenantRepository, RentalUnitRepository rentalUnitRepository, LeaseRepository leaseRepository){
        this.leaseRepository = leaseRepository;
        this.tenantRepository = tenantRepository;
        this.rentalUnitRepository = rentalUnitRepository;
    }

    public void rentUnit() throws ParseException {
        Lease obj = new Lease();
        try {
            System.out.println("Please enter the tenant name:");
            obj.setTenant(tenantRepository.get(input.nextLine()));
            System.out.println("Please enter the rental unit ID:");
            obj.setRentalUnit(rentalUnitRepository.get(input.nextInt()));
            System.out.println("Please Enter the start date of the lease in the format dd/mm/yyyy");
            String dateFormat = "dd/mm/yyyy";
            obj.setStartDate(new SimpleDateFormat(dateFormat).parse(input.nextLine()));
            System.out.println("Please Enter the end date of the lease in the format dd/mm/yyyy");
            obj.setEndDate(new SimpleDateFormat(dateFormat).parse(input.nextLine()));
            System.out.println("Please Enter the monthly rent of the lease");
            obj.setPrice(input.nextDouble());
            rentalUnitRepository.update(obj.getRentalUnit().getId(),true);
            leaseRepository.save(obj);
        }
        catch (Exception e){
            System.out.println("It seems there was an error in renting the unit");
        }
    }

    public void leases(){
        leaseRepository.getAll();
    }
}
