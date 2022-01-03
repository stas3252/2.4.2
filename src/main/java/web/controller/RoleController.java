package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class RoleController {
    @GetMapping("/")
    public String getHomePage() {
        return "role/index";
    }
    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "role/login";
    }
}
