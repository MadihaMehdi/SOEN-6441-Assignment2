package org.example.controllers;

import org.example.Database.TenantRepository;
import org.example.models.Tenant;

import java.util.ArrayList;
import java.util.Scanner;

public class TenantController {

    TenantRepository tenantRepository;
    Scanner input = new Scanner(System.in);

    public TenantController(TenantRepository obj){
        tenantRepository = obj;
    }

    public void createTenant(){
        Tenant obj = new Tenant();
        System.out.println("Please Enter The name of the Tenant");
        obj.setName(input.nextLine());
        System.out.println("Please Enter The email of the Tenant");
        obj.setEmail(input.nextLine());
        tenantRepository.save(obj);
    }

    public Tenant getTenant(String name){
        return tenantRepository.get(name);
    }

    public void allTenants(){
        tenantRepository.getAll();
    }

    public void removeTenant(String name){
        Tenant obj = getTenant(name);
        if(tenantRepository.delete(obj))
            System.out.println("Tenant has been deleted");
        else
            System.out.println("It seems there is no tenant with this name");
    }
}
