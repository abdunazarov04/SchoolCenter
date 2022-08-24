package uz.isystem.centert.teacherType;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherTypesDto {
    private Integer id;
    @NotBlank(message = ("The name cannot be empty or null"))
    private String name;
    @NotBlank(message = ("The display name cannot be empty or null"))
    private String displayName;
}
