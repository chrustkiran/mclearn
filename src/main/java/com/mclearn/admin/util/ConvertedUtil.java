package com.mclearn.admin.util;

import com.mclearn.admin.constant.ErrorMessages;
import com.mclearn.admin.dto.UserDTO;
import com.mclearn.admin.dto.request.AttendanceReq;
import com.mclearn.admin.dto.request.UserReq;
import com.mclearn.admin.entity.Attendance;
import com.mclearn.admin.entity.User;
import com.mclearn.admin.entity.enums.Role;
import com.mclearn.admin.error.AttendanceError;
import com.mclearn.admin.error.InValidRequest;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertedUtil {
    public static Collection<Attendance> convertFromRequest(List<AttendanceReq> attendanceReqList, Map<String, User> usersByUsername) throws AttendanceError {
        if (attendanceReqList == null || attendanceReqList.isEmpty() || usersByUsername == null)
            throw new AttendanceError(ErrorMessages.NULL_EMPTY_MESSAGE);
        return attendanceReqList.stream().filter(r -> usersByUsername.containsKey(r.getStudentId())).
                map(r -> Attendance.builder().date(r.getDate()).studentId(usersByUsername.get(r.getStudentId())).
                        isPresence(r.isPresent()).build()).collect(Collectors.toList());
    }

    public static User convertFromUserRequest(UserReq userReq) {
        if (userReq == null) throw new InValidRequest(ErrorMessages.NULL_EMPTY_MESSAGE);
        return User.builder().userId(userReq.getUsername()).firstName(userReq.getFirstName())
                .lastName(userReq.getLastName()).role(getRole(userReq.getRole()))
                .mobileNumber(userReq.getMobileNumber()).build();
    }

    public static Role getRole(String role) {
        if (role == null || role.isEmpty()) throw new InValidRequest(ErrorMessages.ROLE_IS_EMPTY);
        if ("ADMIN".equalsIgnoreCase(role)) {
            return Role.Admin;
        } else if ("STUDENT".equalsIgnoreCase(role)) {
            return Role.Student;
        }
        throw new InValidRequest(ErrorMessages.ROLE_IS_EMPTY);
    }

    public static UserDTO convertUserDTO(User user) {
        return UserDTO.builder().
                firstName(user.getFirstName()).username(user.getUserId())
                .lastName(user.getLastName()).mobileNumber(user.getMobileNumber()).build();
    }

    public static List<UserDTO> convertUserDTOs(Optional<List<User>> users) {
        return users.orElse(new ArrayList<>()).stream().map(ConvertedUtil::convertUserDTO)
                .collect(Collectors.toList());
    }
}
