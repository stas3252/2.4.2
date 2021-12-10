package web.DAO;


import web.model.Person;

import java.util.List;


public interface PersonDAOI {
    void savePerson(Person person);
    void updatePerson(Person person);
    void deletePersonById(long id);
    Person getPersonById(long id);
    List<Person> listPersons();
}
