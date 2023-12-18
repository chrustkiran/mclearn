package com.mclearn.admin.controller;

import com.mclearn.admin.dto.request.AttendanceReq;
import com.mclearn.admin.service.impl.AttendanceServiceImpl;
import com.mclearn.admin.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceServiceImpl attendanceService;
    @PostMapping
    public ResponseEntity<Boolean> markAttendance(@RequestBody List<AttendanceReq> attendanceReq) {
        ValidatorUtil.validateAttendanceReq(attendanceReq);
        return new ResponseEntity<>(attendanceService.markAttendance(attendanceReq), HttpStatus.OK);
    }


}
