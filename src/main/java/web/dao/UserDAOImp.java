package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> list() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public User getByName(String name) {
        return entityManager
                .createQuery("select User from User u where u.name = :name", User.class)
                .setParameter("name",name)
                .getSingleResult();
    }
}
