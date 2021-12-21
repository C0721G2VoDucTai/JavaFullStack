package models.facillity;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String idFacility, String serviceName, double usingArea, double costRent, int personNumber,
                String typeOfRent, String freeService) {
        super(idFacility, serviceName, usingArea, costRent, personNumber, typeOfRent);
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id Facility = " + getIdFacility() +
                ",serviceName = " + getServiceName()+
                ",usingArea = " + getUsingArea() +
                ",costRent = " + getCostRent() +
                ",personNumber = " + getPersonNumber() +
                ",typeOfRent= " + getTypeOfRent() +
                ",freeService= " + freeService +
                "} " ;
    }
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Room room = (Room) obj;
        return this.getIdFacility().equals(((Room) obj).getIdFacility())
                && this.getServiceName().equals(((Room) obj).getServiceName());
    }
    public String getInformationRoom() {
        return getIdFacility()+ "," +getServiceName() + "," + getUsingArea() +"," + getCostRent()+ "," + getPersonNumber() +
                ","  + getTypeOfRent() + "," + freeService;
    }
}
