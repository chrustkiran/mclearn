package com.mclearn.admin.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttendanceRes implements ResponseData {
    private boolean isSaved;
}
