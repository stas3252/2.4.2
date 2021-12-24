package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping(value = "/")
    public String welcome() {
        return "redirect:/admin/all";
    }

    @GetMapping(value = "/all")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.list());
        return "user/index";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "user/new";
    }

    @PostMapping(value = "/new")
    public String postNewPerson(@ModelAttribute("user") User user,
                              @RequestParam(required=false) String roleAdmin) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByName("ROLE_USER"));
        if (roleAdmin != null && roleAdmin.equals("ROLE_ADMIN")) {
            roles.add(roleService.getRoleByName("ROLE_ADMIN"));
        }
        user.setRoles(roles);
        userService.save(user);

        return "redirect:/admin/";
    }

    @GetMapping("/{id}/update")
    public String update(ModelMap model, @PathVariable("id") long id) {
        User user = userService.getById(id);
        Set<Role> roles = user.getRoles();
        for (Role role: roles) {
            if (role.equals(roleService.getRoleByName("ROLE_ADMIN"))) {
                model.addAttribute("roleAdmin", true);
            }
        }
        model.addAttribute("user", user);
        return "user/update";
    }

    @PostMapping(value = "/update")
    public String postUpdateUser(@ModelAttribute("user") User user,
                                 @RequestParam(required=false) String roleAdmin) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByName("ROLE_USER"));
        if (roleAdmin != null && roleAdmin .equals("ROLE_ADMIN")) {
            roles.add(roleService.getRoleByName("ROLE_ADMIN"));
        }
        user.setRoles(roles);
        userService.update(user);
        return "redirect:/admin/";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }
}
