package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDAO;
import web.model.Role;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    private RoleDAO dao;

    @Autowired
    public void setDao(RoleDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return dao.getRoleByName(name);
    }

    @Override
    @Transactional
    public Role getRole(int id) {
        return dao.getRole(id);
    }

    @Override
    @Transactional
    public List<Role> getRoles() {
        return dao.getRoles();
    }

    @Override
    @Transactional
    public Role getDefaultRole() {
        return dao.getDefaultRole();
    }
}