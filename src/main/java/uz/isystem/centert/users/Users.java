package uz.isystem.centert.users;

import lombok.*;
import uz.isystem.centert.Enum.Gender;
import uz.isystem.centert.userImage.UserImage;
import uz.isystem.centert.userType.UserTypes;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("users"))
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Gender gender;
    private String phone;
    private String email;
    private String password;
    private String name;
    private String surname;
    private Boolean status;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "address_first")
    private String addressFirst;
    @Column(name = "address_second")
    private String addressSecond;


    @ManyToOne
    @JoinColumn(name = ("user_types_id"),insertable = false,updatable = false)
    private UserTypes userTypes;
    @Column(name = ("user_types_id"))
    private Integer userTypesId;

    @ManyToOne
    @JoinColumn(name = ("user_image_id"),insertable = false,updatable = false)
    private UserImage userImage;
    @Column(name = "user_image_id")
    private Integer userImageId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    @Column(name = ("updated_at"))
    private LocalDateTime updateAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
