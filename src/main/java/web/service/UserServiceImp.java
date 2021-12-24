package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {this.userDAO = userDAO;}

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public List<User> list() {
        return userDAO.list();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.getByName(username);
    }
}
