package org.example.models;

import java.util.Scanner;

public abstract class Address {
    private int streetNumber;
    private String streetName;
    private String city;
    private String province;
    private String postalCode;

    Scanner input = new Scanner(System.in);

    public Address() {
    }

    public Address(int streetNumber, String streetName, String city, String province, String postalCode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void BuildAddress(){
        System.out.println("Please enter the city name");
        setCity(input.nextLine());
        System.out.println("Please enter the street name");
        setStreetName(input.nextLine());
        System.out.println("Please enter the street number");
        setStreetNumber(input.nextInt());
        System.out.println("Please enter the province");
        setProvince(input.nextLine());
        System.out.println("Please enter the postal code");
        setPostalCode(input.nextLine());


    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
