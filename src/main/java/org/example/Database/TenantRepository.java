package org.example.Database;

import org.example.models.Tenant;

import java.util.ArrayList;

/**
 * This is the mocked database of the tenants
 * in the system
 */

public class TenantRepository {
    private ArrayList<Tenant> tenantArrayList = new ArrayList<>();

    /**
     * @return the if a tenant has been
     * saved in the database
     */
    public boolean save(Tenant obj){
        return tenantArrayList.add(obj);
    }

    /**
     * @return the if a tenant has been
     * deleted from the database
     */
    public boolean delete(Tenant obj){
        return tenantArrayList.remove(obj);
    }

    /**
     * @return the Tenant by searching
     * through his name in the database
     */
    public Tenant get(String name) {
        Tenant obj = null;
        for (Tenant t : tenantArrayList)
            if (t.getName().equals(name))
                obj =  t;
        return obj;
    }

    /**
     * @return all the tenants stored
     * in the database
     */
    public ArrayList<Tenant> getAll(){
        return tenantArrayList;
    }

}
