package by.louegroove.seleniumfreecodecamp.valueobjects;

// данные гражданина
public class CitizenVO {
    private final String surname;
    private final String name;
    private final String middleName;
    private final String birthDate;
    private final String passport;
    private final String sex;
    private final String address;

    public CitizenVO(String surname, String name, String middleName, String birthDate, String passport, String sex, String address) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.passport = passport;
        this.sex = sex;
        this.address = address;
    }

    // Геттеры
    public String getSurname() { return surname; }
    public String getName() { return name; }
    public String getMiddleName() { return middleName; }
    public String getBirthDate() { return birthDate; }
    public String getPassport() { return passport; }
    public String getSex() { return sex; }
    public String getAddress() { return address; }
}