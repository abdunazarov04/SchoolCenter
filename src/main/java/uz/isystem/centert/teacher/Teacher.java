package uz.isystem.centert.teacher;

import lombok.*;
import uz.isystem.centert.Enum.Gender;
import uz.isystem.centert.teacherType.TeacherTypes;
import uz.isystem.centert.users.Users;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("teachers"))
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = ("user_id"),insertable = false,updatable = false)
    private Users users;
    @Column(name = "users_id")
    private Integer usersId;

    @ManyToOne
    @JoinColumn(name = ("teacher_type_id"),insertable = false,updatable = false)
    private TeacherTypes teacherTypes;
    @Column(name = "teacher_types_id")
    private Integer teacherTypesId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updatedAt"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;

}
