package uz.isystem.centert.userType;

import lombok.*;
import uz.isystem.centert.Enum.Gender;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("user_types"))
public class UserTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "display_name")
    private String displayName;
    private Boolean status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updateAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
