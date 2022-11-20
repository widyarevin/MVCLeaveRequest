package com.proyek.leaverequest.repositories;

import com.proyek.leaverequest.DTO.User.UserGridDTO;
import com.proyek.leaverequest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>  {
//    @Query("select new com.batm.Day2.DTO.User.UserGridDTO(u.username, u.role.name) from User u")
//    public List<UserGridDTO> getUsernameRoleName();
}
