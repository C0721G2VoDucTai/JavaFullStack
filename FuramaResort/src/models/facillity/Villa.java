package models.facillity;

import models.facillity.Facility;

public class Villa extends Facility {
    private String standardRoom;
    private double poolArea;
    private int numberOfFloor;

    public Villa() {
    }

    public Villa(String idFacility, String serviceName, double usingArea, double costRent, int personNumber,
                 String typeOfRent, String standardRoom, double poolArea, int numberOfFloor) {
        super(idFacility, serviceName, usingArea, costRent, personNumber, typeOfRent);
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "Id = " + getIdFacility() +
                ",serviceName = " + getServiceName()+
                ",usingArea = " + getUsingArea() +
                ",costRent = " + getCostRent() +
                ",personNumber = " + getPersonNumber() +
                ",typeOfRent = " + getTypeOfRent() +
                ",standardRoom = " + standardRoom +
                ",poolArea = " + poolArea +
                ",numberOfFloor = " + numberOfFloor +
                "} ";
    }
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Villa villa = (Villa) obj;
        return this.getIdFacility().equals(((Villa) obj).getIdFacility())
                && this.getServiceName().equals(((Villa) obj).getServiceName());
    }
    public String getInformationVilla() {
        return getIdFacility()+ "," +getServiceName() + "," + getUsingArea() +"," + getCostRent()+ "," + getPersonNumber() +
                ","  + getTypeOfRent() + "," + standardRoom + ","  +poolArea +  ","  +numberOfFloor;
    }
}
