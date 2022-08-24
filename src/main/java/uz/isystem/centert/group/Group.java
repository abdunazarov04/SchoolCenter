package uz.isystem.centert.group;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.centert.course.Course;
import uz.isystem.centert.groupType.GroupTypes;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("groups"))
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = ("course_id"), insertable = false, updatable = false)
    private Course course;
    @Column(name = ("course_id"))
    private Integer courseId;


    @ManyToOne
    @JoinColumn(name = ("groups_type_id"), insertable = false, updatable = false)
    private GroupTypes groupTypes;
    @Column(name = ("groups_type_id"))
    private Integer groupTypeId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updateAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;


}
