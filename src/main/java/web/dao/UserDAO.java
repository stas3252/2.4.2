package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    void update(User user);
    void deleteById(long id);
    User getById(long id);
    List<User> list();
    User getByName(String personName);
}
