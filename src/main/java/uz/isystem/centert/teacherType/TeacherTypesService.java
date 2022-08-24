package uz.isystem.centert.teacherType;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.centert.exeption.ServerBadRequestException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherTypesService {
    private TeacherTypesRepository teacherTypesRepository;

    public Boolean create(TeacherTypesDto teacherTypesDto) {
      TeacherTypes teacherTypes = new TeacherTypes();
      teacherTypes.setStatus(true);
      teacherTypes.setCreatedAt(LocalDateTime.now());
      teacherTypesRepository.save(teacherTypes);
      return true;
    }


    public TeacherTypesDto get(Integer id) {
       TeacherTypes teacherTypes = getEntity(id);
       TeacherTypesDto teacherTypesDto = new TeacherTypesDto();
       teacherTypesDto.setName(teacherTypes.getName());
       teacherTypesDto.setDisplayName(teacherTypes.getDisplayName());
       convertDtoToEntity(teacherTypesDto,teacherTypes);
       return teacherTypesDto;
    }

    public Boolean update(Integer id, TeacherTypesDto teacherTypesDto) {
      TeacherTypes teacherTypes = getEntity(id);
      teacherTypes.setUpdateAt(LocalDateTime.now());
      convertEntityToDto(teacherTypes,teacherTypesDto);
      return true;
    }

    public Boolean delete(Integer id) {
        TeacherTypes teacherTypes = getEntity(id);
        teacherTypes.setDeletedAt(LocalDateTime.now());
        teacherTypesRepository.save(teacherTypes);
        return true;
    }


    private void convertDtoToEntity(TeacherTypesDto teacherTypesDto, TeacherTypes teacherTypes ){
        teacherTypesDto.setName(teacherTypes.getName());
        teacherTypesDto.setDisplayName(teacherTypes.getDisplayName());
        teacherTypesDto.setId(teacherTypes.getId());
    }

    private void convertEntityToDto(TeacherTypes teacherTypes, TeacherTypesDto teacherTypesDto){
        teacherTypes.setId(teacherTypesDto.getId());
        teacherTypes.setName(teacherTypesDto.getName());
        teacherTypes.setDisplayName(teacherTypesDto.getDisplayName());
    }

    public TeacherTypes getEntity(Integer id) {
        Optional<TeacherTypes> optional = teacherTypesRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new ServerBadRequestException("User not found");
        }
        return optional.get();
    }

}
