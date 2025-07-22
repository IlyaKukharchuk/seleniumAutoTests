package by.louegroove.seleniumfreecodecamp.valueobjects;

public class BirthDetailsVO {
    private final String birthAddress;
    private final String mother;
    private final String father;
    private final String grandma;
    private final String grandpa;

    public BirthDetailsVO(String birthAddress, String mother, String father,
                          String grandma, String grandpa) {
        this.birthAddress = birthAddress;
        this.mother = mother;
        this.father = father;
        this.grandma = grandma;
        this.grandpa = grandpa;
    }

    // Геттеры

    public String getBirthAddress() {
        return birthAddress;
    }

    public String getMother() {
        return mother;
    }

    public String getFather() {
        return father;
    }

    public String getGrandma() {
        return grandma;
    }

    public String getGrandpa() {
        return grandpa;
    }
}
