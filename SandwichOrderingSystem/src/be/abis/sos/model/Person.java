package be.abis.sos.model;

public class Person {

    public static int counter = 0;

    private int personId;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.personId = ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + lastName;
    }
}
