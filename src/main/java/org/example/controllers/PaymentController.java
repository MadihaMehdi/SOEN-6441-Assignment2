package org.example.controllers;

import org.example.Database.LeaseRepository;
import org.example.models.PaymentSystem;
import org.example.models.Tenant;

import java.util.Scanner;

public class PaymentController {
    private PaymentSystem system;

    LeaseRepository leaseRepository;

    public PaymentController(LeaseRepository leaseRepository){
        system = PaymentSystem.getInstance();
        this.leaseRepository = leaseRepository;
    }

    public void payRent(){
        leaseRepository.getAllTenants();
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the tenant name: ");
        Tenant tenant = leaseRepository.getSingleTenant(input.nextLine());
        if(system.pay(tenant))
            System.out.println(tenant.getName()+ " " + "has paid the rent");
        else
            System.out.println("The rent is not paid");
    }



}
