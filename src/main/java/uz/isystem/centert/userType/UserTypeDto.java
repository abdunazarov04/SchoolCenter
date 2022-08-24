package uz.isystem.centert.userType;

import lombok.*;
import uz.isystem.centert.Enum.Gender;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTypeDto {
    private Integer id;
    private String name;
    private String displayName;
    private Gender gender;
}
