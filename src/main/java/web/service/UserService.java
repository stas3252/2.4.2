package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void save(User user);
    void update(User user);
    void deleteById(long id);
    User getById(long id);
    List<User> list();
    UserDetails loadUserByUsername(String username);
}
