package mockito;

public class Person {

    private final Integer persionID;
    private final String personName;

    public Person(Integer persionID, String personName){
        this.persionID = persionID;
        this.personName = personName;
    }

    public Integer getPersionID() {
        return persionID;
    }

    public String getPersonName() {
        return personName;
    }
}
