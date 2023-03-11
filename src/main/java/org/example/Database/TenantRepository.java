package org.example.Database;

import org.example.models.Tenant;

import java.util.ArrayList;

public class TenantRepository {
    private ArrayList<Tenant> tenantArrayList = new ArrayList<>();

    public void save(Tenant obj){
        tenantArrayList.add(obj);
    }
    public boolean delete(Tenant obj){
        return tenantArrayList.contains(obj);
    }
    public Tenant get(String name) {
        Tenant obj = null;
        for (Tenant t : tenantArrayList)
            if (t.getName().equals(name))
                obj =  t;
        return obj;
    }

    public void getAll(){
        for(Tenant t: tenantArrayList)
            System.out.println(t);
    }

}
