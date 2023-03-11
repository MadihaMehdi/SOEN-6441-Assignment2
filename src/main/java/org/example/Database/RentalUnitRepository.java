package org.example.Database;

import org.example.models.RentalUnit;

import java.util.ArrayList;

public class RentalUnitRepository {
    private ArrayList<RentalUnit> rentalUnitList = new ArrayList<>();

    public void save(RentalUnit obj){
        rentalUnitList.add(obj);
    }
    public boolean delete(RentalUnit obj){
        return rentalUnitList.contains(obj);
    }
    public RentalUnit get(int id) {
        RentalUnit obj = null;
        for (RentalUnit r : rentalUnitList)
            if (r.getId() == id)
                obj =  r;
        return obj;
    }
    public void getAll(){
        for(RentalUnit r: rentalUnitList)
            System.out.println(r);
    }

    public void getAllRented(){
        for(RentalUnit r: rentalUnitList)
            if(r.isRented())
                System.out.println(r);
    }

    public void getAllVacant(){
        for(RentalUnit r: rentalUnitList)
            if(!r.isRented())
                System.out.println(r);
    }

    public boolean update(int Id, boolean type){
        boolean flag = false;
        for(RentalUnit u: rentalUnitList)
            if(u.getId() == Id) {
                u.setRented(type);
                flag = true;
            }
        return flag;
    }

}
