package _11_dsa_stack_queue.optional.to_chuc_du_lieu_hop_ly;

import javax.xml.crypto.Data;
import java.util.Date;

public class Staff {
    private String name;
    private String sex;
    private String birthDay;

    public Staff() {
    }

    public Staff(String name, String sex, String birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name +
                ", sex='" + sex +
                ", birthDay='" + birthDay + '\'' +
                '}'+ '\'';
    }
}
