package com.example.springboot.project.controller;

import com.example.springboot.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUserById(@RequestParam(value = "id", required = false) Long id,
                                 Model model) {
        model.addAttribute("user", userServise.showUserById(id));
        return "updateUserById";
    }
    @PutMapping("/update")
    public String update(@RequestParam(value = "id", required = false) Long id,
                         @ModelAttribute("user") User user) {
        userServise.updateUserById(id, user);
        return "redirect:/";
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServise.deleteUserById(id);
        return "redirect:/";
    }
}
