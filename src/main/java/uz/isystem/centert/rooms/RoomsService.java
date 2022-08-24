package uz.isystem.centert.rooms;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.centert.exeption.ServerBadRequestException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoomsService {
   private RoomsRepository roomsRepository;

    public RoomsDto get(Integer id) {
       Rooms rooms = getEntity(id);
       RoomsDto roomsDto = new RoomsDto();
       convertDtoEntity(roomsDto,rooms);
       return roomsDto;
    }

    public Boolean create(RoomsDto roomsDto) {
        Rooms rooms = new Rooms();
        rooms.setStatus(true);
        rooms.setCreatedAt(LocalDateTime.now());
        roomsRepository.save(rooms);
        return true;
    }

    public Boolean update(Integer id, RoomsDto roomsDto) {
       Rooms rooms = getEntity(id);
       rooms.setUpdateAt(LocalDateTime.now());
       convertEntityDto(rooms,roomsDto);
       return true;
    }

    public Boolean delete(Integer id) {
      Rooms rooms = getEntity(id);
      rooms.setDeletedAt(LocalDateTime.now());
      roomsRepository.save(rooms);
      return true;
    }

    private void convertDtoEntity(RoomsDto roomsDto, Rooms rooms){
        roomsDto.setId(rooms.getId());
        roomsDto.setName(rooms.getName());
        roomsDto.setStatus(rooms.getStatus());
    }

    private void convertEntityDto(Rooms rooms, RoomsDto roomsDto){
        rooms.setId(roomsDto.getId());
        rooms.setName(roomsDto.getName());
        rooms.setStatus(roomsDto.getStatus());
    }
    public Rooms getEntity(Integer id){
        Optional<Rooms> optional = roomsRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new ServerBadRequestException("Rooms not found");
        }
        return optional.get();
    }
}
