package org.example.models;

import java.util.HashMap;

public class PaymentSystem {
    public static volatile PaymentSystem instance;
    private HashMap<Integer,Boolean> map;

    private PaymentSystem(){
        map = new HashMap<>();
    }
    public static PaymentSystem getInstance(){
        if(instance == null){
            synchronized (PaymentSystem.class){
                if(instance == null){
                    instance = new PaymentSystem();
                }
            }
        }
        return instance;
    }

    public boolean pay(Tenant obj){
        return map.put(obj.getId(), true);
    }

    @Override
    public String toString() {
        return "PaymentSystem{" +
                "map=" + map +
                '}';
    }
}
