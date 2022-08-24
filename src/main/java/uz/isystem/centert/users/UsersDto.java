package uz.isystem.centert.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uz.isystem.centert.Enum.Gender;
import uz.isystem.centert.userType.UserTypes;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersDto {
    private Integer id;
    @NotBlank(message = ("The name cannot be empty or null"))
    private String name;
    @NotBlank(message = ("The surname cannot be empty or null"))
    private String surname;
    @NotBlank(message = ("The firstname cannot be empty or null"))
    private String firstName;
    @NotBlank(message = ("The lastname cannot be empty or null"))
    private String lastName;
    @NotBlank(message = ("The middleName cannot be empty or null"))
    private String middleName;
    @NotBlank(message = ("The phone cannot be empty or null"))
    private String phone;
    @NotBlank(message = ("The email cannot be empty or null"))
    private String email;
    @NotBlank(message = ("The password cannot be empty or null"))
    private String password;
    @NotBlank(message = ("The address cannot be empty or null"))
    private String addressFirst;
    @NotBlank(message = ("The second cannot be empty or null"))
    private String addressSecond;

    private UserTypes userTypes;
    private Integer userTypesId;

    private Image usersImageId;
    private Integer UserImageId;

    private Gender gender;
}
