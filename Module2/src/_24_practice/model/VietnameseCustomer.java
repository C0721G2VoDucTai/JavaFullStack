package _24_practice.model;

public class VietnameseCustomer extends Customer {
    String type;
    int usageLevel;
    public VietnameseCustomer() {
    }

    public VietnameseCustomer(String id, String name, int usageLevel, String type) {
        super(id, name);
        this.type = type;
        this.usageLevel = usageLevel;
    }

    public int getUsageLevel() {
        return usageLevel;
    }

    public void setUsageLevel(int usageLevel) {
        this.usageLevel = usageLevel;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  "VietnameseCustomer{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", usageLevel=" + usageLevel +
                ", type=" + type +
                '}';
    }

    @Override
    public String getInformation() {
        return getId() +"," +getName() +"," +usageLevel +"," +type;
    }
}
