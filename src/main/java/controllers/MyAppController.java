package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyAppController {

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/add")
    public String addUser() {
        return "add_user";
    }

    @GetMapping("/remove")
    public String removeUser() {
        return "remove_user";
    }

    @GetMapping("/change")
    public String changeUser() {
        return "change_user";
    }
}
