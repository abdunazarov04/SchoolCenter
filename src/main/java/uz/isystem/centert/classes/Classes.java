package uz.isystem.centert.classes;

import lombok.*;
import uz.isystem.centert.attendanceType.AttendanceType;
import uz.isystem.centert.rooms.Rooms;
import uz.isystem.centert.userGroups.UserGroups;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("classes"))
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean status;
    private String name;
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = ("room_id"),insertable = false,updatable = false)
    private Rooms rooms;

    @Column(name = "room_id")
    private Integer roomId;

    @ManyToOne
    @JoinColumn(name = ("user_groups_id"),insertable = false,updatable = false)
    private UserGroups userGroups;

    @Column(name = "user_groups_id")
    private Integer userGroupId;


    @ManyToOne
    @JoinColumn(name = ("attendance_type_id"),insertable = false,updatable = false)
    private AttendanceType attendanceType;

    @Column(name = "attendance_type_id")
    private Integer attendanceTypeId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updateAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
