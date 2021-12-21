package models.contract;

public class Contract {
    private int idContract;
    private int idBooking;
    private double deposit;
    private double totalPay;
    private int idCostumer;

    public Contract() {
    }

    public Contract(int idContract, int idBooking, double deposit, double totalPay, int idCostumer) {
        this.idContract = idContract;
        this.idBooking = idBooking;
        this.deposit = deposit;
        this.totalPay = totalPay;
        this.idCostumer = idCostumer;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public int getIdCostumer() {
        return idCostumer;
    }

    public void setIdCostumer(int idCostumer) {
        this.idCostumer = idCostumer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract=" + idContract +
                ", idBooking=" + idBooking +
                ", deposit=" + deposit +
                ", totalPay=" + totalPay +
                ", idCostumer=" + idCostumer +
                '}';
    }

    public String getInformationContract() {
        return idContract + "," + idBooking + "," +deposit +"," + totalPay +"," + idCostumer;

    }
}

