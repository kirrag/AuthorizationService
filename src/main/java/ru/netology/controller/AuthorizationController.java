package ru.netology.controller;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import ru.netology.service.AuthorizationService;
import ru.netology.authority.Authorities;
import ru.netology.model.Account;

@RestController
public class AuthorizationController {
    AuthorizationService service;
    
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid Account account) {
        return service.getAuthorities(account);
    }
}

