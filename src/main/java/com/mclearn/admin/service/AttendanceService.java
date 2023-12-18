package com.mclearn.admin.service;

import com.mclearn.admin.dto.request.AttendanceReq;
import com.mclearn.admin.error.AttendanceError;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendanceService {
    Boolean markAttendance(List<AttendanceReq> attendanceReq) throws AttendanceError;
}
