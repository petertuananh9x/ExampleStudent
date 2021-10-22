package net.codejava.service.user;


import org.springframework.security.core.userdetails.UserDetailsService;

import net.codejava.model.User;
import net.codejava.service.IGeneralService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}