package uz.isystem.centert.group;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.centert.course.Course;
import uz.isystem.centert.groupType.GroupTypes;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class GroupDto {
        private Integer id;
        @NotBlank(message = ("The name cannot be empty or null"))
        private String name;
        //@NotBlank(message = ("The course id cannot be empty or null"))
        private Course course;
        private Integer courseId;
        //@NotBlank(message = ("The group type id cannot be empty or null"))
        private GroupTypes groupTypes;
        private Integer groupTypeId;
}
