package com.mclearn.admin.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {
    String erroCode;
    String message;
    String status;
    ResponseData data;

}
