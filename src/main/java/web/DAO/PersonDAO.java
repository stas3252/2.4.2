package web.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Component
public class PersonDAO {
    @PersistenceContext()
    private EntityManager entityManager;

    public void savePerson(Person person) {
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updatePerson(Person person) {
        entityManager.merge(person);
        entityManager.getTransaction().commit();
    }

    public void deletePersonById(long id) {
        entityManager.remove(entityManager.find(Person.class, id));
        entityManager.getTransaction().commit();
    }
    public Person getPersonById(long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> listPersons() {
        return entityManager.createQuery("SELECT person FROM Person person", Person.class).getResultList();
    }
}
