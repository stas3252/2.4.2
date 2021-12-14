package web.dao;

import web.model.Person;

import java.util.List;


public interface PersonDAO {
    void savePerson(Person person);
    void updatePerson(Person person);
    void deletePersonById(long id);
    Person getPersonById(long id);
    List<Person> listPersons();
}
