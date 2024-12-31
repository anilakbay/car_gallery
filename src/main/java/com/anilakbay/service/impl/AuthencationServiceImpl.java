package com.anilakbay.service.impl;

import com.anilakbay.dto.AuthRequest;
import com.anilakbay.dto.DtoUser;
import com.anilakbay.model.User;
import com.anilakbay.repository.UserRepository;
import com.anilakbay.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthencationServiceImpl implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private User createUser(AuthRequest input) {
        User user = new User();
        user.setCreatedTime(new Date());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return user;
    }

    @Override
    public DtoUser register(AuthRequest input) {

        DtoUser dtoUser = new DtoUser();

        User savedUser = userRepository.save(createUser(input));

        BeanUtils.copyProperties(savedUser, dtoUser);

        return dtoUser;
    }
}
