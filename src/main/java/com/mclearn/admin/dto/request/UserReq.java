package com.mclearn.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {
    private String username;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String role;
}
