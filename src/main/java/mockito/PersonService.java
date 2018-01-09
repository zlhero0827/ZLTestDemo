package mockito;

public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao){
        this.personDao = personDao;
    }

    public boolean update(Integer personId, String name){
        Person person = personDao.fetchPerson(personId);
        if(person!=null){
            Person updatePerson = new Person(person.getPersionID(), name);
            personDao.update(updatePerson);
            return true;
        }else {
            return false;
        }
    }
}
