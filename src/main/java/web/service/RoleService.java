package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);

    Role getRole(int id);

    List<Role> getRoles();

    Role getDefaultRole();
}