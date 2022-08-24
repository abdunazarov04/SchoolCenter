package uz.isystem.centert.attendanceType;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("attendanceTypes"))
public class AttendanceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  name;
    @Column(name = "reason_message")
    private String reasonMessage;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updateAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
