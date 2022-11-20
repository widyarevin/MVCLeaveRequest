package com.proyek.leaverequest.controller;

import com.proyek.leaverequest.DTO.User.RegisterDTO;
import com.proyek.leaverequest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("login")
    public String login (Model model){
        return "user/login";
    }

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("user", new RegisterDTO());
        return "user/register";
    }

    @PostMapping("register")
    public String register(RegisterDTO dto){
        userService.register(dto);
        return "redirect:/user/login";
    }

}
