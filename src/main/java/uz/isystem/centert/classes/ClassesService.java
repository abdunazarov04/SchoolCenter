package uz.isystem.centert.classes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.centert.attendanceType.AttendanceTypeService;
import uz.isystem.centert.exeption.ServerBadRequestException;
import uz.isystem.centert.rooms.RoomsService;
import uz.isystem.centert.userGroups.UserGroupsService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClassesService {
    private ClassesRepository classesRepository;
    private RoomsService roomsService;
    private UserGroupsService userGroupsService;
    private AttendanceTypeService attendanceTypeService;

    public Boolean create(ClassesDto classesDto) {
        Classes classes = new Classes();
        classes.setStatus(true);
        classes.setCreatedAt(LocalDateTime.now());
        classes.setRooms(roomsService.getEntity(classesDto.getRoomId()));
        classes.setUserGroups(userGroupsService.getEntity(classesDto.getUserGroupId()));
        classes.setAttendanceType(attendanceTypeService.getEntity(classesDto.getAttendanceTypeId()));
        classesRepository.save(classes);
        return true;
    }

    public ClassesDto get(Integer id) {
        Classes classes = getEntity(id);
        ClassesDto classesDto = new ClassesDto();
        classesDto.setRooms(classes.getRooms());
        classesDto.setUserGroups(classes.getUserGroups());
        classesDto.setAttendanceType(classes.getAttendanceType());
        convertDtoEntity(classesDto,classes);
        return classesDto;
    }

    public Boolean update(Integer id, ClassesDto    classesDto) {
        Classes classes = getEntity(id);
        classes.setUpdateAt(LocalDateTime.now());
        classes.setRooms(roomsService.getEntity(classesDto.getRoomId()));
        classes.setUserGroups(userGroupsService.getEntity(classesDto.getUserGroupId()));
        classes.setAttendanceType(attendanceTypeService.getEntity(classesDto.getAttendanceTypeId()));
        convertEntityDto(classes, classesDto);
        classesRepository.save(classes);
        return true;
    }

    public Boolean delete(Integer id) {
        Classes classes = getEntity(id);
        classes.setDeletedAt(LocalDateTime.now());
        classesRepository.save(classes);
        return true;
    }

    private void convertDtoEntity(ClassesDto classesDto, Classes classes){
        classesDto.setName(classes.getName());
        classesDto.setRoomId(classes.getRoomId());
        classesDto.setUserGroupId(classes.getUserGroupId());
        classesDto.setAttendanceTypeId(classes.getAttendanceTypeId());
        classesDto.setId(classes.getId());
    }
    private void convertEntityDto(Classes classes, ClassesDto classesDto){
        classes.setName(classesDto.getName());
        classes.setId(classesDto.getId());
        classes.setRoomId(classesDto.getRoomId());
        classes.setUserGroupId(classesDto.getUserGroupId());
        classes.setAttendanceTypeId(classesDto.getAttendanceTypeId());
    }

    private Classes getEntity(Integer id){
        Optional<Classes> optional = classesRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new ServerBadRequestException("Classes not found");
        }
        return optional.get();
    }
}
