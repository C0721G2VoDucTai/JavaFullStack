package bean;

public class Ticket {
    private int id;
    private Book book;
    private Student student;
    private String status;
    private String starDay;
    private String endDay;


    public Ticket() {
    }

    public Ticket(int id, Book book, Student student, String status, String starDay, String endDay) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.status = status;
        this.starDay = starDay;
        this.endDay = endDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStarDay() {
        return starDay;
    }

    public void setStarDay(String starDay) {
        this.starDay = starDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }
}
