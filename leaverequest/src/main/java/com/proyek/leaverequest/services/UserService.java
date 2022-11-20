package com.proyek.leaverequest.services;

import com.proyek.leaverequest.DTO.User.RegisterDTO;

public interface UserService {
    boolean register(RegisterDTO dto);
}
