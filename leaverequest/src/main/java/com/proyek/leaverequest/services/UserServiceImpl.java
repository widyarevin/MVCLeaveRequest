package com.proyek.leaverequest.services;

import com.proyek.leaverequest.DTO.User.RegisterDTO;
import com.proyek.leaverequest.entities.User;
import com.proyek.leaverequest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public boolean register(RegisterDTO dto) {
        if (dto.getEmail().isEmpty()){
            throw new IllegalArgumentException("Email cannot be empty!");
        }
        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        userRepository.save(new User(dto.getFullName(), dto.getEmail(), encodedPassword,dto.getTotalLeave(), dto.getManagerId()));
        return userRepository.findById(dto.getId()).isPresent();
    }
}
