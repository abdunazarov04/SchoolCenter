package uz.isystem.centert.teacher;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uz.isystem.centert.teacherType.TeacherTypes;
import uz.isystem.centert.users.Users;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDto {
    private Integer id;
    private Users users;
    private Integer usersId;
    private TeacherTypes teacherTypes;
    private Integer teacherTypesId;


}
