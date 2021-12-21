package models.person;

public class Employee extends Person {
    private String educationLevel;
    private String position;
    private double salary;
    public  Employee(){
    }

    public Employee(int id, String name, String birthDay, String sex, String idCard, String phoneNumber,
                    String email, String educationLevel, String position, double salary1) {
        super(id, name, birthDay, sex, idCard, phoneNumber,email);
        this.educationLevel = educationLevel;
        this.position = position;
        this.salary = salary1;
    }


    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + super.getId() +
                ", name='" + super.getName() +
                ", birthDay='" +super.getBirthDay() +
                ", sex='" + super.getSex() +
                ", idCard=" + super.getIdCard() +
                ", phoneNumber='" + super.getPhoneNumber() +
                ", email='" + super.getEmail() +
                "educationLevel='" + educationLevel +
                ", position='" + position +
                ", salary=" + salary +
                "} ";
    }
    public String getInformationEmployee() {
        return super.getId()+ "," + super.getName()+"," +super.getBirthDay() +"," +super.getSex() +","
                +super.getIdCard()+"," +super.getPhoneNumber() +"," +super.getEmail() +"," +educationLevel+
                "," + position + "," + salary;
    }
}


