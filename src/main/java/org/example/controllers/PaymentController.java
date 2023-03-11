package org.example.controllers;

import org.example.Database.LeaseRepository;
import org.example.models.PaymentSystem;
import org.example.models.Tenant;

import java.util.Scanner;

/**
 * This is the payment controller
 * which performs every operation
 * regarding the tenants paying for
 * their rented property
 */
public class PaymentController {
    private PaymentSystem system;

    LeaseRepository leaseRepository;

    /**
     * Constructor
     */
    public PaymentController(LeaseRepository leaseRepository){
        system = PaymentSystem.getInstance();
        this.leaseRepository = leaseRepository;
    }

    /**
     * @return a string indicating if
     * a tenant has payed the rent
     */
    public String payRent(){
        leaseRepository.getAllTenants();
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the tenant name: ");
        Tenant tenant = leaseRepository.getSingleTenant(input.nextLine());
        if(system.pay(tenant))
            return (tenant.getName()+ " " + "has paid the rent");
        else
            return ("The rent is not paid");
    }



}
