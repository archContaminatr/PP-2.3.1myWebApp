package com.example.mywebapp.controller;

import com.example.mywebapp.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.mywebapp.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String modelMainPage(Model model) {
        model.addAttribute("usersList", userService.allUsers());
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editPage";
    }

    @PatchMapping("/{id}")
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        return "addPage";
    }

    @PostMapping("/add")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        System.out.println(user.getFirstName());
        return new ModelAndView("redirect:/");
    }

    @DeleteMapping("/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/");
    }

}
