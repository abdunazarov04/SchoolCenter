package uz.isystem.centert.rooms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.isystem.centert.groupType.GroupTypes;

import java.util.Optional;
@Repository
public interface RoomsRepository extends JpaRepository<Rooms,Integer> {
    Optional<Rooms> findByIdAndDeletedAtIsNull(Integer id);
}
