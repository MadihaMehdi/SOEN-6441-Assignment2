package org.example.models;

public class ApartmentAddress extends Address{
    private int unitNumber;

    public ApartmentAddress() {
    }

    public ApartmentAddress(int streetNumber, String streetName, String city, String province, String postalCode, int unitNumber) {
        super(streetNumber, streetName, city, province, postalCode);
        this.unitNumber = unitNumber;
    }

    @Override
    public void BuildAddress() {
        super.BuildAddress();
        System.out.println("Please enter the unitNumber");
        setUnitNumber(input.nextInt());

    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "{" +
                "unitNumber=" + unitNumber +
                '}';
    }
}
