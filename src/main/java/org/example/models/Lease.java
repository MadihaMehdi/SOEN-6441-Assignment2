package org.example.models;

import java.util.Date;

public class Lease {
    private static int Id = 1000;
    private Tenant tenant;
    private RentalUnit rentalUnit;
    private Date startDate;
    private Date endDate;
    private double price;

    public Lease(){
        this.setId(Id);
        Id++;
    }

    public Lease(Tenant tenant, RentalUnit rentalUnit, Date startDate, Date endDate, double price) {
        this.tenant = tenant;
        this.rentalUnit = rentalUnit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void setRentalUnit(RentalUnit rentalUnit) {
        this.rentalUnit = rentalUnit;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public RentalUnit getRentalUnit() {
        return rentalUnit;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "Id=" + Id +
                ", tenant=" + tenant +
                ", rentalUnit=" + rentalUnit +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                '}';
    }
}
