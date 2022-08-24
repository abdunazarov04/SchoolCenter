package uz.isystem.centert.teacher;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.centert.exeption.ServerBadRequestException;
import uz.isystem.centert.teacherType.TeacherTypesService;
import uz.isystem.centert.users.UsersService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {

    private TeacherRepository teacherRepository;

    private TeacherTypesService teacherTypesService;

    private UsersService usersService;

    public Boolean create(TeacherDto teacherDto) {
       Teacher teacher = new Teacher();
       teacher.setStatus(true);
       teacher.setCreatedAt(LocalDateTime.now());
       teacher.setUsers(usersService.getEntity(teacherDto.getUsersId()));
       teacher.setTeacherTypes(teacherTypesService.getEntity(teacherDto.getTeacherTypesId()));
       teacherRepository.save(teacher);
       return true;
    }

    public TeacherDto get(Integer id) {
        Teacher teacher = getEntity(id);
        TeacherDto teacherDto = new TeacherDto();
        teacher.setUsers(teacher.getUsers());
        teacher.setTeacherTypes(teacher.getTeacherTypes());
        convertDtoToEntity(teacher,teacherDto);
        return teacherDto;
    }

    public Boolean update(Integer id, TeacherDto teacherDto) {
        Teacher teacher = getEntity(id);
        teacher.setUpdatedAt(LocalDateTime.now());
        convertEntityToDto(teacher,teacherDto);
        teacherRepository.save(teacher);
        return true;
    }

    public Boolean delete(Integer id) {
       Teacher teacher = getEntity(id);
       teacher.setDeletedAt(LocalDateTime.now());
       teacherRepository.save(teacher);
       return true;
    }

    private void convertDtoToEntity(Teacher teacher, TeacherDto teacherDto){
       teacher.setId(teacherDto.getId());
       teacher.setUsersId(teacherDto.getUsersId());
       teacher.setTeacherTypesId(teacherDto.getTeacherTypesId());
    }

    private void convertEntityToDto(Teacher teacher, TeacherDto teacherDto){
       teacher.setId(teacherDto.getId());
       teacher.setUsersId(teacherDto.getUsersId());
       teacher.setTeacherTypesId(teacherDto.getTeacherTypesId());
    }

    public Teacher getEntity(Integer teacherId) {
        Optional<Teacher> optional = teacherRepository.findByIdAndDeletedAtIsNull(teacherId);
        if (optional.isEmpty()){
            throw new ServerBadRequestException("Teacher not found");
        }
        return optional.get();
    }
}
