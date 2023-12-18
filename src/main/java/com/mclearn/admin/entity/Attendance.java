package com.mclearn.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "T_ATTENDANCE")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attendanceId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( referencedColumnName = "userId")
    private User studentId;
    private Date date;
    private Boolean isPresence;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "userId")
    private User markedBy;
}
