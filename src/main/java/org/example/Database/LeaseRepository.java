package org.example.Database;

import org.example.models.Lease;
import org.example.models.Tenant;

import java.util.ArrayList;

public class LeaseRepository {
    private ArrayList<Lease> leaseArrayList = new ArrayList<>();

    public void save(Lease obj){
        leaseArrayList.add(obj);
    }
    public boolean delete(Lease obj){
        return leaseArrayList.contains(obj);
    }
    public Lease get(int Id) {
        Lease obj = null;
        for (Lease l : leaseArrayList)
            if (l.getId() == Id)
                obj =  l;
        return obj;
    }

    public void getAll(){
        for(Lease l: leaseArrayList)
            System.out.println(l);
    }
    public void getAllTenants(){
        for(Lease l: leaseArrayList)
            System.out.println(l.getTenant());
    }
    public Tenant getSingleTenant(String name){
        Tenant obj = null;
        for(Lease l: leaseArrayList)
            if(l.getTenant().getName().equals(name))
                obj = l.getTenant();
        return obj;
    }

}
