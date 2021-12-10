package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.DAO.PersonDAO;
import web.model.Person;

import javax.transaction.Transactional;
import java.util.List;

public interface PersonServiceI {
    void savePerson(Person person);
    void updatePerson(Person person);
    void deletePersonById(long id);
    Person getPersonById(long id);
    List<Person> listPersons();
}
