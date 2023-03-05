package org.example.models;

public abstract class RentalUnit {
    private String Id;
    private int bedrooms;
    private int bathrooms;
    private int area;
    private Address address;
    private boolean isRented;


    public RentalUnit() {
    }

    public RentalUnit(String id, int bedrooms, int bathrooms, int area, Address address, boolean isRented) {
        Id = id;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.area = area;
        this.address = address;
        this.isRented = isRented;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getId() {
        return Id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getArea() {
        return area;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isRented() {
        return isRented;
    }

    @Override
    public String toString() {
        return "RentalUnit{" +
                "Id='" + Id + '\'' +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", area=" + area +
                ", address=" + address +
                ", isRented=" + isRented +
                '}';
    }
}
