package models.facillity;

import java.util.HashMap;

public class Facility {
    private String idFacility;
    private String serviceName;
    private double usingArea;
    private double costRent;
    private int personNumber;
    private String typeOfRent;

    public Facility() {
    }
    public Facility(String serviceName) {
        this.serviceName = serviceName;
    }

    public Facility(String idFacility,String serviceName, double usingArea, double costRent, int personNumber,
                    String typeOfRent) {
        this.serviceName = serviceName;
        this.usingArea = usingArea;
        this.costRent = costRent;
        this.personNumber = personNumber;
        this.typeOfRent = typeOfRent;
        this.idFacility = idFacility;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(double usingArea) {
        this.usingArea = usingArea;
    }

    public double getCostRent() {
        return costRent;
    }

    public void setCostRent(double costRent) {
        this.costRent = costRent;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id " + idFacility +
                ",serviceName='" + serviceName +
                ",usingArea=" + usingArea +
                ",costRent=" + costRent +
                ",personNumber=" + personNumber +
                ",typeOfRent='" + typeOfRent +
                '}';
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Facility facility = (Facility) obj;
        return this.idFacility.equals(((Facility) obj).idFacility)
                && this.getServiceName().equals(((Facility) obj).serviceName);
    }

    public String getInformationFacility() {
        return idFacility + "," + serviceName + "," + usingArea + "," + costRent + "," + personNumber + "," + typeOfRent;
    }
}
