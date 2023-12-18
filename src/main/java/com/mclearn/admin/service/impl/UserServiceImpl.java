package com.mclearn.admin.service.impl;

import com.mclearn.admin.constant.ErrorMessages;
import com.mclearn.admin.dto.UserDTO;
import com.mclearn.admin.dto.request.UserReq;
import com.mclearn.admin.entity.User;
import com.mclearn.admin.error.InValidRequest;
import com.mclearn.admin.error.UserServiceException;
import com.mclearn.admin.repository.UserRepository;
import com.mclearn.admin.service.UserService;
import com.mclearn.admin.util.ConvertedUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public Boolean saveUser(UserReq userReq) {
        try {
            userRepository.save(ConvertedUtil.convertFromUserRequest(userReq));
            log.info(String.format("[saveUser] User with user id %s has been successfully save!", userReq.getUsername()));
        } catch (Exception ex) {
            throw new UserServiceException(ex.getMessage());
        }
        return true;
    }

    @Override
    public List<UserDTO> getAllUsers() {
            return null;
    }

    @Override
    public List<UserDTO> getAllUsersByUserName(Collection<String> userNames) {
        return null;
    }

    @Override
    public UserDTO getUserWithByName(String userName) {
        UserDTO userDTO = null;
        if (userName == null || userName.isEmpty()) {
            throw new InValidRequest(ErrorMessages.USER_NAME_EMPTY);
        }
        try {
            Optional<User> user = userRepository.findById(userName);
            if (user.isPresent()) {
                 userDTO = ConvertedUtil.convertUserDTO(user.get());
            } else {
                throw new UserServiceException("No such user with username :: " + userName);
            }
        } catch (Exception ex) {
            throw new UserServiceException(ex.getMessage());
        }
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllStudents(String role) {
        List<UserDTO> userDTOS = null;
        Optional<List<User>> users = userRepository.findAllByRole(ConvertedUtil.getRole(role));
        if (users != null && !users.isEmpty()) {
            userDTOS = ConvertedUtil.convertUserDTOs(users);
        }
        return userDTOS;
    }

    List<User> getAllUserEntityByUserName(Collection<String> userNames) {
        try {
            return userRepository.findAllById(userNames);
        } catch (Exception ex) {
            throw new UserServiceException(ex.getMessage());
        }
    }




}
