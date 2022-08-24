package uz.isystem.centert.userGroups;

import lombok.*;
import uz.isystem.centert.group.Group;
import uz.isystem.centert.users.Users;
import uz.isystem.centert.teacher.Teacher;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("user_groups"))
public class UserGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer  id;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = ("group_id"),insertable = false,updatable = false)
    private Group group;
    @Column(name = "group_id")
    private Integer groupId;

    @ManyToOne
    @JoinColumn(name = ("user_id"),insertable = false,updatable = false)
    private Users users;
    @Column(name = "user_id")
    private Integer usersId;

    @ManyToOne
    @JoinColumn(name = ("teacher_id"),insertable = false,updatable = false)
    private Teacher teacher;
    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updateAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}

