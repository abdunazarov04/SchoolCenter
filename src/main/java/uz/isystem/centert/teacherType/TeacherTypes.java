package uz.isystem.centert.teacherType;

import lombok.*;
import uz.isystem.centert.Enum.Gender;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("teacherTypes"))
public class TeacherTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private Boolean status;
    @Column(name = "display_name")
    private String displayName;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updateAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
