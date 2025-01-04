package com.anilakbay.service.impl;

import com.anilakbay.dto.AuthRequest;
import com.anilakbay.dto.AuthResponse;
import com.anilakbay.dto.DtoUser;
import com.anilakbay.dto.RefreshTokenRequest;
import com.anilakbay.exception.BaseException;
import com.anilakbay.exception.ErrorMessage;
import com.anilakbay.exception.MessageType;
import com.anilakbay.jwt.JWTService;
import com.anilakbay.model.RefreshToken;
import com.anilakbay.model.User;
import com.anilakbay.repository.RefreshTokenRepository;
import com.anilakbay.repository.UserRepository;
import com.anilakbay.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthencationServiceImpl implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private User createUser(User input) {
        User user = new User();
        user.setCreatedTime(new Date());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return user;
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreatedTime(new Date());
        refreshToken.setExpirationDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public DtoUser register(AuthRequest input) {

        DtoUser dtoUser = new DtoUser();

        User savedUser = userRepository.save(createUser(input));

        BeanUtils.copyProperties(savedUser, dtoUser);

        return dtoUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest input) {

        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(input.getUsername(), input.getPassword());
           authenticationProvider.authenticate(authenticationToken);

            Optional<User> optUser = userRepository.findByUsername(input.getUsername());

            String accessToken = jwtService.generateToken(optUser.orElse(null));
            RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optUser.get()));

            return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());

        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, e.getMessage()));
        }

    }

    public boolean isValidRefreshToken(Date expiredDate) {
        return new Date().before(expiredDate);
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest input) {

        List<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(input.getRefreshToken());
        if(optRefreshToken.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND, input.getRefreshToken()));
        }

        if(!isValidRefreshToken(optRefreshToken.get(0).getExpirationDate())) {
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_IS_EXPIRED, input.getRefreshToken()));
        }

        User user = optRefreshToken.get(0).getUser();
        String accessToken = jwtService.generateToken(user);
        refreshTokenRepository.save(createRefreshToken(user));

        return null;
    }
}
