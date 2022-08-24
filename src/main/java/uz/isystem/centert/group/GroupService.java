package uz.isystem.centert.group;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import uz.isystem.centert.course.CourseService;
import uz.isystem.centert.exeption.ServerBadRequestException;
import uz.isystem.centert.groupType.GroupTypesService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupService {
    private GroupRepository groupRepository;
    private GroupTypesService groupTypeService;
    private CourseService courseService;

    public Boolean create(GroupDto dto) {
        Group group = new Group();
        group.setStatus(true);
        group.setId(dto.getId());
        group.setName(dto.getName());
        group.setCourseId(dto.getCourseId());
        group.setGroupTypeId(dto.getGroupTypeId());
        group.setCourse(courseService.getEntity(dto.getCourseId()));
        group.setGroupTypes(groupTypeService.getEntity(dto.getGroupTypeId()));
        group.setCreatedAt(LocalDateTime.now());
        groupRepository.save(group);
        return true;
    }

    public GroupDto get(Integer id) {
        Group group = getEntity(id);
        GroupDto dto = new GroupDto();
        dto.setId(group.getId());
        dto.setName(group.getName());
        dto.setCourseId(group.getCourseId());
        dto.setCourse(group.getCourse());
        dto.setGroupTypeId(group.getGroupTypeId());
        dto.setGroupTypes(group.getGroupTypes());
        return dto;
    }

    public Boolean update(Integer id, GroupDto dto) {
        Group group = getEntity(id);
        group.setName(dto.getName());
        group.setCourseId(dto.getCourseId());
        group.setGroupTypeId(dto.getGroupTypeId());
        group.setCourse(courseService.getEntity(dto.getCourseId()));
        group.setGroupTypes(groupTypeService.getEntity(dto.getGroupTypeId()));
        group.setUpdateAt(LocalDateTime.now());
        groupRepository.save(group);
        return true;
    }

    public Boolean delete(Integer id) {
        Group group = getEntity(id);
        group.setDeletedAt(LocalDateTime.now());
        groupRepository.save(group);
        return true;
    }

    public Group getEntity(Integer id) {
        Optional<Group> optional = groupRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new ServerBadRequestException("Group not found");
        }
        return optional.get();
    }
}
