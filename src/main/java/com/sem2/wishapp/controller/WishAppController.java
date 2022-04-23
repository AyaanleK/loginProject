package com.sem2.wishapp.controller;

import com.sem2.wishapp.entity.User;
import com.sem2.wishapp.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WishAppController {

  @Autowired
  private UserRepository repo;

  @GetMapping("/index")
  public String index(){
    return "index";
  }

  @GetMapping("/register")
  public String showSignUpForm(Model model){
    model.addAttribute("user", new User());

    return "signup_form";
  }

  @PostMapping("/process_register")
  public String processRegistration(User user){
    repo.save(user);

    return "registration_success";
  }
}
