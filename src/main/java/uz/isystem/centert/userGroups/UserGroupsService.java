package uz.isystem.centert.userGroups;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.centert.exeption.ServerBadRequestException;
import uz.isystem.centert.group.GroupService;
import uz.isystem.centert.teacher.TeacherService;
import uz.isystem.centert.users.UsersService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserGroupsService {
    private UserGroupsRepository userGroupsRepository;
    private GroupService groupService;
    private UsersService usersService;
    private TeacherService teacherService;

    public Boolean create(UserGroupsDto userGroupsDto) {
       UserGroups userGroups = new UserGroups();
       userGroups.setStatus(true);
       userGroups.setCreatedAt(LocalDateTime.now());
       userGroups.setGroup(groupService.getEntity(userGroupsDto.getGroupId()));
       userGroups.setUsers(usersService.getEntity(userGroupsDto.getUsersId()));
       userGroups.setTeacher(teacherService.getEntity(userGroupsDto.getTeacherId()));
       userGroupsRepository.save(userGroups);
       return true;

    }

    public UserGroupsDto get(Integer id) {
      UserGroups userGroups = getEntity(id);
      UserGroupsDto userGroupsDto = new UserGroupsDto();
      userGroupsDto.setUsers(userGroups.getUsers());
      userGroupsDto.setGroup(userGroups.getGroup());
      userGroupsDto.setTeacher(userGroups.getTeacher());
      convertDtoToEntity(userGroupsDto,userGroups);
      return userGroupsDto;
    }

    public Boolean update(Integer id, UserGroupsDto userGroupsDto) {
       UserGroups userGroups = getEntity(id);
       userGroups.setUpdateAt(LocalDateTime.now());
       userGroups.setUsers(usersService.getEntity(userGroupsDto.getUsersId()));
       userGroups.setGroup(groupService.getEntity(userGroups.getGroupId()));
       userGroups.setTeacher(teacherService.getEntity(userGroups.getTeacherId()));
       convertEntityToDto(userGroups,userGroupsDto);
       userGroupsRepository.save(userGroups);
       return true;
    }

    public Boolean delete(Integer id) {
        UserGroups userGroups = getEntity(id);
        userGroups.setDeletedAt(LocalDateTime.now());
        userGroupsRepository.save(userGroups);
        return true;
    }

    private void convertDtoToEntity(UserGroupsDto userGroupsDto, UserGroups userGroups){
        userGroupsDto.setGroupId(userGroups.getGroupId());
        userGroupsDto.setUsersId(userGroups.getUsersId());
        userGroupsDto.setTeacherId(userGroupsDto.getTeacherId());
        userGroupsDto.setId(userGroupsDto.getId());
    }

    private void convertEntityToDto(UserGroups userGroups, UserGroupsDto userGroupsDto){
        userGroups.setGroupId(userGroupsDto.getGroupId());
        userGroups.setUsersId(userGroupsDto.getUsersId());
        userGroups.setTeacherId(userGroupsDto.getTeacherId());
        userGroups.setId(userGroupsDto.getId());
    }


    public UserGroups getEntity(Integer id) {
        Optional<UserGroups> optional = userGroupsRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new ServerBadRequestException("User not found");
        }
        return optional.get();
    }
}
