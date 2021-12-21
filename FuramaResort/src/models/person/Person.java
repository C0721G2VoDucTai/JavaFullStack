package models.person;

 class Person {
    private int id;
    private String name;
    private String birthDay;
    private String sex;
    private String idCard;
    private String phoneNumber;
    private String email;
    public Person() {
    }
    public Person (int id){
        this.id = id;
    }

     public Person(int id, String name, String birthDay, String sex, String idCard,String phoneNumber,
                   String email) {
         this.id = id;
         this.name = name;
         this.birthDay = birthDay;
         this.sex = sex;
         this.idCard = idCard;
         this.phoneNumber = phoneNumber;
         this.email = email;
     }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


     @Override
     public String toString() {
         return "Person{" +
                 "id=" + id +
                 ", name='" + name +
                 ", birthDay='" + birthDay +
                 ", sex='" + sex +
                 ", idCard=" + idCard +
                 ", phoneNumber='" + phoneNumber +
                 ", email='" + email +
                 '}';
     }
 }
