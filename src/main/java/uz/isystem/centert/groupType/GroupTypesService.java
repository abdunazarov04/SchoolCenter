package uz.isystem.centert.groupType;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.centert.exeption.ServerBadRequestException;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
@AllArgsConstructor
public class GroupTypesService {
    private GroupTypesRepository groupTypesRepository;

    public Boolean create(GroupTypesDto groupTypesDto) {
        GroupTypes groupTypes = new GroupTypes();
        groupTypes.setStatus(true);
        groupTypes.setCreatedAt(LocalDateTime.now());
        groupTypesRepository.save(groupTypes);
        return true;
    }

    public GroupTypesDto get(Integer id) {
        GroupTypes groupTypes = getEntity(id);
        GroupTypesDto groupTypesDto = new GroupTypesDto();
        convertDtoEntity(groupTypesDto,groupTypes);
        return groupTypesDto;
    }

    public Boolean update(Integer id, GroupTypesDto groupTypesDto) {
        GroupTypes groupTypes = getEntity(id);
        groupTypes.setUpdateAt(LocalDateTime.now());
        convertEntityDto(groupTypes,groupTypesDto);
        return true;
    }

    public Boolean delete(Integer id) {
        GroupTypes groupTypes = getEntity(id);
        groupTypes.setDeletedAt(LocalDateTime.now());
        groupTypesRepository.save(groupTypes);
        return true;
    }

    private void convertDtoEntity(GroupTypesDto groupTypesDto, GroupTypes groupTypes){
        groupTypesDto.setId(groupTypes.getId());
        groupTypesDto.setName(String.valueOf(groupTypes.getName()));
    }

    private void convertEntityDto(GroupTypes groupTypes, GroupTypesDto groupTypesDto){
        groupTypes.setId(groupTypesDto.getId());
        groupTypes.setName(Integer.valueOf(groupTypesDto.getName()));
    }

    public GroupTypes getEntity(Integer id){
        Optional<GroupTypes> optional = groupTypesRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new ServerBadRequestException("User not found");
        }
        return optional.get();
    }
}
