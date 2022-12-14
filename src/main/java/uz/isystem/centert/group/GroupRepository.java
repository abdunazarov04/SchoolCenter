package uz.isystem.centert.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
    Optional<Group> findByIdAndDeletedAtIsNull(Integer id);
}
