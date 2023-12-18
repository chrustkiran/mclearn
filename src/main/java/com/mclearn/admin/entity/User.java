package com.mclearn.admin.entity;

import com.mclearn.admin.entity.enums.Role;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_USER")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    private String userId;

    @NotNull
    private String firstName;
    @Nullable
    private String lastName;
    @Nullable
    private String mobileNumber;
    @Enumerated(EnumType.ORDINAL)
    private Role role;
}
