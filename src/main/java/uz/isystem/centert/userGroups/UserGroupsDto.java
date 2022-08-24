package uz.isystem.centert.userGroups;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uz.isystem.centert.group.Group;
import uz.isystem.centert.teacher.Teacher;
import uz.isystem.centert.users.Users;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroupsDto {
    private Integer id;
    private Group group;
    @NotNull
    private Integer groupId;
    private Users users;
    @NotNull
    private Integer usersId;
    private Teacher teacher;
    @NotNull
    private Integer teacherId;


    private LocalDateTime cratedAt;
    private LocalDateTime deleteAt;
    private LocalDateTime updatedAt;

}
