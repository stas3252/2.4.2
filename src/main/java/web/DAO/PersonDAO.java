package web.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDAO implements PersonDAOI{
    @PersistenceContext()
    private EntityManager entityManager;

    public void savePerson(Person person) {
        entityManager.persist(person);
        entityManager.close();
    }

    public void updatePerson(Person person) {
        entityManager.merge(person);
    }

    public void deletePersonById(long id) {
        entityManager.remove(entityManager.find(Person.class, id));
    }
    public Person getPersonById(long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> listPersons() {
        return entityManager.createQuery("SELECT person FROM Person person", Person.class).getResultList();
    }
}
