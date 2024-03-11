package com.example.springboot.project.controller;

import com.example.springboot.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.springboot.project.servise.UserServise;


@Controller
public class UserController {

    private final UserServise userServise;

    @Autowired
    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("user", userServise.getUsers());

        return "getUsers";
    }

    @GetMapping("/id")
    public String showUserById(@RequestParam(value = "id", required = false) Long id, Model model) {
        model.addAttribute("user", userServise.showUserById(id));

        return "showUserById";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userServise.saveUser(user);
        return "redirect: /";
    }

    @GetMapping("/updateUser")
    public String updateUserById(@RequestParam(value = "id", required = false) Long id,
                                 Model model) {
        model.addAttribute("user", userServise.showUserById(id));
        return "updateUserById";
    }
    @PostMapping("/update")
    public String update(@RequestParam(value = "id", required = false) Long id,
                         @ModelAttribute("user") User user) {
        userServise.updateUserById(id, user);
        return "redirect: /";
    }
    @GetMapping("/d")
    public String deleteUser(@ModelAttribute("user") User user) {
        userServise.deleteUserById(user.getId());
        return "redirect: /";
    }
}
