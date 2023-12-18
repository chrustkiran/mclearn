package com.mclearn.admin.service;

import com.mclearn.admin.dto.UserDTO;
import com.mclearn.admin.dto.request.UserReq;
import com.mclearn.admin.entity.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    Boolean saveUser(UserReq userReq);
    List<UserDTO> getAllUsers();

    List<UserDTO> getAllUsersByUserName(Collection<String> userNames);

    UserDTO getUserWithByName(String userName);

    List<UserDTO> getAllStudents(String role);
}
