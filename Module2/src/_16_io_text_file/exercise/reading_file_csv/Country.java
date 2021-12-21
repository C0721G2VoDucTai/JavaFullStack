package _16_io_text_file.exercise.reading_file_csv;

public class Country {
    private String id;
    private String sign;
    private String name;

    public Country() {
    }

    public Country(String id, String sign, String name) {
        this.id = id;
        this.sign = sign;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id +"," + sign +"," + name;
    }
}
