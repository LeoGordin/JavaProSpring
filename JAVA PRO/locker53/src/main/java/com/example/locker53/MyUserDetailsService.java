package com.example.locker53;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// знает как возвратить данные о пользователе
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // загрузить пользователя из UserRepository по имени
        User user = userRepository.getUserByUsername(username);
        // если такого нет, выбросить UsernameNotFoundException
        if(user == null)
            throw new UsernameNotFoundException("User with username " + username + " not found");
        // создать и вернуть UserDetails из загруженного пользователя
        MyUserDetails details = new MyUserDetails(user);
        return details;
    }
    // перерыв до 20:53
}
