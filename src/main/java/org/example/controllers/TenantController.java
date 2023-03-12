package org.example.controllers;

import org.example.Database.TenantRepository;
import org.example.models.Tenant;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the tenant controller
 * which performs every operation
 * regarding the tenants
 */

public class TenantController {

    TenantRepository tenantRepository;
    Scanner input = new Scanner(System.in);

    /**
     * Constructor
     */
    public TenantController(TenantRepository obj){
        tenantRepository = obj;
    }

    /**
     * create a tenant and
     * store it in the database
     */
    public void createTenant(){
        Tenant obj = new Tenant();
        try {
            System.out.println("Please Enter The name of the Tenant");
            obj.setName(input.nextLine());
            System.out.println("Please Enter The email of the Tenant");
            obj.setEmail(input.nextLine());
            tenantRepository.save(obj);
            System.out.println("Tenant has been created");
            System.out.println(obj);
        }
        catch (Exception e){
            System.out.println("It seems something is wrong");
        }
    }

    /**
     * @return  a tenant
     * from the database by
     * searching his name
     */
    public Tenant getTenant(String name){
        return tenantRepository.get(name);
    }

    /**
     * @return all the tenants in
     * the database
     */
    public ArrayList<Tenant> allTenants(){
        return tenantRepository.getAll();
    }

    /**
     * @return a string indicating if
     * a tenant has been deleted or not
     */
    public String removeTenant(String name){
        try {
            Tenant obj = getTenant(name);
            if (tenantRepository.delete(obj))
                return ("Tenant has been deleted");
            else
                return ("It seems there is no tenant with this name");
        }
        catch (Exception e){
            System.out.println("It seems something is wrong");
        }
        return "";
    }

    /**
     * display all the tenants in the database
     * These tenants may not have a lease
     */
    public void displayTenants(){
        try {
            for (Tenant t : allTenants())
                System.out.println(t);
        }
        catch (Exception e){
            System.out.println("It seems something is wrong with this operation");
        }
    }
}
