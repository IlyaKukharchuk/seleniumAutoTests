package by.louegroove.seleniumfreecodecamp.valueobjects;

// данные заявителя
public class ApplicantVO {
    private final String surname;
    private final String name;
    private final String middleName;
    private final String phone;
    private final String passport;
    private final String address;

    public ApplicantVO(String surname, String name, String middleName, String phone, String passport, String address) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.phone = phone;
        this.passport = passport;
        this.address = address;
    }

    // Геттеры
    public String getSurname() { return surname; }
    public String getName() { return name; }
    public String getMiddleName() { return middleName; }
    public String getPhone() { return phone; }
    public String getPassport() { return passport; }
    public String getAddress() { return address; }
}