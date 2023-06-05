package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, String> {

    @Query("select user from UserDto user  where user.userID = ?1 and user.password = ?2")
    UserDto checkLoginUserByUserIdAndPassword(String userID, String password);

}
