package uz.isystem.centert.userType;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.centert.exeption.ServerBadRequestException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserTypeService {
   private UserTypeRepository userTypeRepository;

    public UserTypeDto get(Integer id) {
       UserTypes userTypes = getEntity(id);
       UserTypeDto userTypeDto = new UserTypeDto();
       convertDtoToEntity(userTypeDto, userTypes);
       return userTypeDto;

    }

    public Boolean create(UserTypeDto userTypeDto) {
        UserTypes userTypes = new UserTypes();
        userTypes.setStatus(true);
        userTypes.setCreatedAt(LocalDateTime.now());
        userTypes.setGender(userTypeDto.getGender());
        userTypeRepository.save(userTypes);
        return true;
    }

    public Boolean update(Integer id, UserTypeDto userTypeDto) {
        UserTypes userTypes = getEntity(id);
        userTypes.setUpdatedAt(LocalDateTime.now());
       convertEntityToDto(userTypes, userTypeDto);
        userTypeRepository.save(userTypes);
        return true;
    }

    public Boolean delete(Integer id) {
       UserTypes userTypes = getEntity(id);
       userTypes.setDeletedAt(LocalDateTime.now());
       userTypeRepository.save(userTypes);
       return true;
    }

    public UserTypes getEntity(Integer id) {
        Optional<UserTypes> optional = userTypeRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new ServerBadRequestException("User not found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(UserTypeDto userTypeDto, UserTypes userTypes){
        userTypeDto.setId(userTypes.getId());
        userTypeDto.setName(userTypes.getName());
        userTypeDto.setDisplayName(userTypes.getName());
    }

    private void convertEntityToDto(UserTypes userTypes, UserTypeDto userTypeDto){
        userTypes.setName(userTypeDto.getName());
        userTypes.setDisplayName(userTypeDto.getDisplayName());
    }
}
