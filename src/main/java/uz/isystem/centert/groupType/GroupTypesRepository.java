package uz.isystem.centert.groupType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GroupTypesRepository extends JpaRepository<GroupTypes,Integer> {
    Optional<GroupTypes> findByIdAndDeletedAtIsNull(Integer id);
}
