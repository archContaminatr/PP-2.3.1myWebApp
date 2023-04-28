package com.example.controllers;

import com.example.entity.User;
import com.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.service.UserService;

@Controller
public class MyAppController {

    @Autowired
    private final UserService userService;

//    public MyAppController() {}

    @Autowired
    public MyAppController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String emptyPage() {
        return "view";
    }

    @GetMapping("/")
    public String modelMainPage(Model model) {
        model.addAttribute("usersList", userService.allUsers());
        return "users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editPage";
    }

    @PostMapping("/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        return "addPage";
    }

    @PostMapping(value = "/add")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.deleteUser(id);
        return modelAndView;
    }


}
