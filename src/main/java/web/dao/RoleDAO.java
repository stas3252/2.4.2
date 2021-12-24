package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDAO {
    Role getRoleByName(String name);

    Role getRole(int id);

    List<Role> getRoles();

    Role getDefaultRole();
}