package _25_practice2.model;

public class MovieShowTimes {
    private String id;
    private String nameFilm;
    private String dayShow;
    private int numberTicket;

    public MovieShowTimes() {
    }

    public MovieShowTimes(String id, String nameFilm, String dayShow, int numberTicket) {
        this.id = id;
        this.nameFilm = nameFilm;
        this.dayShow = dayShow;
        this.numberTicket = numberTicket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getDayShow() {
        return dayShow;
    }

    public void setDayShow(String dayShow) {
        this.dayShow = dayShow;
    }

    public int getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(int numberTicket) {
        this.numberTicket = numberTicket;
    }

    @Override
    public String toString() {
        return "MovieShowTimes{" +
                "id='" + id +
                ", name='" + nameFilm +
                ", day='" + dayShow +
                ", numberTicket=" + numberTicket +
                '}';
    }

    public String getInformationFilm() {
        return id + "," + nameFilm + "," + dayShow + "," + numberTicket;

    }
}
