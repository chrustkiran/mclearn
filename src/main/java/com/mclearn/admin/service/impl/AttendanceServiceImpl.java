package com.mclearn.admin.service.impl;

import com.mclearn.admin.constant.ErrorMessages;
import com.mclearn.admin.dto.request.AttendanceReq;
import com.mclearn.admin.entity.User;
import com.mclearn.admin.error.AttendanceError;
import com.mclearn.admin.repository.AttendanceRepository;
import com.mclearn.admin.service.AttendanceService;
import com.mclearn.admin.service.UserService;
import com.mclearn.admin.util.ConvertedUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;

    private final UserServiceImpl userService;
    @Override
    public Boolean markAttendance(List<AttendanceReq> attendanceReq) throws AttendanceError {
        if (attendanceReq == null || attendanceReq.isEmpty()) {
            throw new AttendanceError(ErrorMessages.NULL_EMPTY_MESSAGE);
        }
        try {
            List<String> userIds = attendanceReq.stream().map(AttendanceReq::getStudentId).toList();
            List<User> users = userService.getAllUserEntityByUserName(userIds);
            Map<String, User> usersByUsername = Optional.ofNullable(users).orElse(new ArrayList<>()).
                    stream().collect(Collectors.toMap(u -> u.getUserId(), u -> u, (oldKey,newKey)->oldKey));
            attendanceRepository.saveAll(ConvertedUtil.convertFromRequest(attendanceReq, usersByUsername));
            return true;
        } catch (Exception e) {
            throw new AttendanceError(e.getMessage());
        }
    }
}
