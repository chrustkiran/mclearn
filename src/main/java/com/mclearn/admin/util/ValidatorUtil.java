package com.mclearn.admin.util;

import com.mclearn.admin.dto.request.AttendanceReq;
import com.mclearn.admin.dto.request.UserReq;
import com.mclearn.admin.error.InValidRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Slf4j
public class ValidatorUtil {
    public static void validateAttendanceReq(List<AttendanceReq> attendanceReq) throws InValidRequest {
        log.debug("");
        if (attendanceReq == null || attendanceReq.isEmpty()) throw new InValidRequest("invalid");
    }

    public static void validateUserReq(UserReq userReqDTO) {
        if (userReqDTO == null) throw new InValidRequest("Invalid user request");
    }
}
