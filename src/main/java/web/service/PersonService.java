package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.DAO.PersonDAO;
import web.model.Person;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService implements PersonServiceI{
    private PersonDAO personDAO;
    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional
    public void savePerson(Person person) {
        personDAO.savePerson(person);
    }
    @Transactional
    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }
    @Transactional
    public void deletePersonById(long id) {
        personDAO.deletePersonById(id);
    }
    @Transactional
    public Person getPersonById(long id) {
        return personDAO.getPersonById(id);
    }
    @Transactional
    public List<Person> listPersons() {
        return personDAO.listPersons();
    }
}
