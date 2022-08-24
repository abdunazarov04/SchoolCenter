package uz.isystem.centert.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import uz.isystem.centert.attendanceType.AttendanceType;
import uz.isystem.centert.rooms.Rooms;
import uz.isystem.centert.userGroups.UserGroups;

import javax.validation.constraints.NotNull;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassesDto {
    private Integer id;
    @NotBlank(message = ("The name cannot be empty or null"))
    private String name;
    private Rooms rooms;
    @NotNull
    private Integer roomId;
    private AttendanceType attendanceType;
    @NotNull
    private Integer attendanceTypeId;
    private UserGroups userGroups;
    @NotNull
    private Integer userGroupId;
}
