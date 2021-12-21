package models.facillity;

import models.facillity.Facility;

public class House extends Facility {
    private String standardRoom;
    private int numberOfFloor;

    public House() {
    }


    public House(String idFacility, String serviceName, double usingArea, double costRent, int personNumber,
                 String typeOfRent, String standardRoom, int numberOfFloor) {
        super(idFacility, serviceName, usingArea, costRent, personNumber, typeOfRent);
        this.standardRoom = standardRoom;
        this.numberOfFloor = numberOfFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "Id = " + getIdFacility() +
                ",serviceName = " + getServiceName()+
                ",usingArea = " + getUsingArea() +
                ",costRent = " + getCostRent() +
                ",personNumber = "  + getPersonNumber() +
                ",typeOfRent = " + getTypeOfRent() +
                ",standardRoom = " + standardRoom +
                ",numberOfFloor = " + numberOfFloor +
                "}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        House house = (House) obj;
        return this.getIdFacility().equals(((House) obj).getIdFacility())
                && this.getServiceName().equals(((House) obj).getServiceName());
    }

    public String getInformationHouse() {
        return getIdFacility()+ "," + getServiceName() + "," + getUsingArea() +"," + getCostRent()+ "," + getPersonNumber() +
                ","  + getTypeOfRent() + "," + standardRoom + ","  +numberOfFloor;
    }
}
