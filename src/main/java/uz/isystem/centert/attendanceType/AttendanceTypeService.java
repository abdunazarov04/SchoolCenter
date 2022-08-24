package uz.isystem.centert.attendanceType;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.centert.exeption.ServerBadRequestException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendanceTypeService {
    private AttendanceTypeRepository attendanceTypeRepository;

    public Boolean create(AttendanceTypeDto attendanceTypeDto) {
        AttendanceType attendanceType = new AttendanceType();
        attendanceType.setCreatedAt(LocalDateTime.now());
        attendanceTypeRepository.save(attendanceType);
        return true;
    }

    public AttendanceTypeDto get(Integer id) {
        AttendanceType attendanceType = getEntity(id);
        AttendanceTypeDto attendanceTypeDto = new AttendanceTypeDto();
        convertDtoToEntity(attendanceTypeDto,attendanceType);
        return attendanceTypeDto;
    }

    public Boolean update(Integer id, AttendanceTypeDto attendanceTypeDto) {
       AttendanceType attendanceType = getEntity(id);
       attendanceType.setUpdateAt(LocalDateTime.now());
       convertEntityToDto(attendanceType,attendanceTypeDto);
       attendanceTypeRepository.save(attendanceType);
       return true;
    }

    public Boolean delete(Integer id) {
        AttendanceType attendanceType = getEntity(id);
        attendanceType.setDeletedAt(LocalDateTime.now());
        attendanceTypeRepository.save(attendanceType);
        return true;
    }

    private void convertDtoToEntity(AttendanceTypeDto attendanceTypeDto,AttendanceType attendanceType){
        attendanceTypeDto.setId(attendanceType.getId());
        attendanceTypeDto.setName(attendanceType.getName());
        attendanceTypeDto.setReasonMessage(attendanceType.getReasonMessage());
    }

    private void convertEntityToDto(AttendanceType attendanceType, AttendanceTypeDto attendanceTypeDto){
        attendanceType.setId(attendanceTypeDto.getId());
        attendanceType.setName(attendanceTypeDto.getName());
        attendanceType.setReasonMessage(attendanceTypeDto.getReasonMessage());
    }


    public AttendanceType getEntity(Integer id) {
        Optional<AttendanceType> optional = attendanceTypeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new ServerBadRequestException("Attendance type not found");
        }
        return optional.get();
    }
}
