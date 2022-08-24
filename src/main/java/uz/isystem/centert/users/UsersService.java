package uz.isystem.centert.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.centert.exeption.ServerBadRequestException;
import uz.isystem.centert.userType.UserTypeService;
import uz.isystem.s.students.service.UserImageService;

import java.time.LocalDateTime;

import java.util.Optional;
@Service
@AllArgsConstructor
public class UsersService {

    private UsersRepository usersRepository;

    private UserTypeService userTypeService;

    private UserImageService userImageService;

    public Boolean create(UsersDto userDto) {
        Users users = new Users();
        users.setStatus(true);
        users.setGender(userDto.getGender());
        users.setCreatedAt(LocalDateTime.now());
        users.setUserTypes(userTypeService.getEntity(userDto.getUserTypesId()));
        users.setUserImage(userImageService.getEntity(userDto.getUserImageId()));
        users.setGender(userDto.getGender());
        usersRepository.save(users);
        return true;
    }

    public UsersDto get(Integer id) {
        Users users = getEntity(id);
        UsersDto usersDto = new UsersDto();
        usersDto.setUserTypes(users.getUserTypes());
        convertDtoToEntity(usersDto,users);
        return usersDto;
    }

    public Boolean update(Integer id, UsersDto userDto) {
        Users users = getEntity(id);
        users.setUpdateAt(LocalDateTime.now());
        users.setUserTypes(userTypeService.getEntity(userDto.getUserTypesId()));
        convertEntityToDto(users,userDto);
        usersRepository.save(users);
        return true;
    }

    public Boolean delete(Integer id) {
       Users users = getEntity(id);
       users.setDeletedAt(LocalDateTime.now());
       usersRepository.save(users);
       return true;
    }


    private void convertDtoToEntity(UsersDto usersDto, Users users){
        usersDto.setId(users.getId());
        usersDto.setName(users.getName());
        usersDto.setPhone(users.getPhone());
        usersDto.setEmail(users.getEmail());
        usersDto.setGender(users.getGender());
        usersDto.setSurname(users.getSurname());
        usersDto.setUserImageId(users.getUserImageId());
        usersDto.setUserTypesId(users.getUserTypesId());
        usersDto.setAddressFirst(users.getAddressFirst());
        usersDto.setAddressSecond(users.getAddressSecond());
        usersDto.setUserImageId(users.getUserImageId());
    }

    public Users getEntity(Integer id){
        Optional<Users> optional = usersRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new ServerBadRequestException("User not found");
        }
        return optional.get();
    }
    private void convertEntityToDto(Users users, UsersDto usersDto){
        users.setName(usersDto.getName());
        users.setPhone(usersDto.getPhone());
        users.setEmail(usersDto.getEmail());
        users.setGender(usersDto.getGender());
        users.setSurname(usersDto.getSurname());
        users.setPassword(usersDto.getPassword());
        users.setUserImageId(users.getUserImageId());
        users.setAddressFirst(usersDto.getAddressFirst());
        users.setAddressSecond(usersDto.getAddressSecond());
        users.setUserTypesId(usersDto.getUserTypesId());
        users.setUserImageId(usersDto.getUserImageId());
    }
}
