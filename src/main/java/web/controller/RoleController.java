package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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
