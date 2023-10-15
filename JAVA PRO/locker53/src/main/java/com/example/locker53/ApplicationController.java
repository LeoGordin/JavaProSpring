package com.example.locker53;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ApplicationController {
    @GetMapping("/open")
    public String open()
    {
        return "open";
    }

    @GetMapping("/secure")
    public String secure(
            Principal principal // авторизованный пользователь
            // для которого выполняется этот метод
    )
    {
        Object user  = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails details = null;
        if(user instanceof UserDetails)
        {
            details = (UserDetails) user;
        }
        return "secure " + principal.getName() + " " + details.getAuthorities();
    }
}
