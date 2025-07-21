package by.louegroove.seleniumfreecodecamp.valueobjects;

// данные о браке
public class MarriageDetailsVO {
    private final String registrationDate;
    private final String newSurname;
    private final String spouseSurname;
    private final String spouseName;
    private final String spouseMiddleName;
    private final String spouseBirthDate;
    private final String spousePassport;

    public MarriageDetailsVO(String registrationDate, String newSurname, String spouseSurname,
                             String spouseName, String spouseMiddleName, String spouseBirthDate, String spousePassport) {
        this.registrationDate = registrationDate;
        this.newSurname = newSurname;
        this.spouseSurname = spouseSurname;
        this.spouseName = spouseName;
        this.spouseMiddleName = spouseMiddleName;
        this.spouseBirthDate = spouseBirthDate;
        this.spousePassport = spousePassport;
    }

    // Геттеры
    public String getRegistrationDate() { return registrationDate; }
    public String getNewSurname() { return newSurname; }
    public String getSpouseSurname() { return spouseSurname; }
    public String getSpouseName() { return spouseName; }
    public String getSpouseMiddleName() { return spouseMiddleName; }
    public String getSpouseBirthDate() { return spouseBirthDate; }
    public String getSpousePassport() { return spousePassport; }
}