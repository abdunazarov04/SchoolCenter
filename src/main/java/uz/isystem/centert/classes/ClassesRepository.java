package uz.isystem.centert.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ClassesRepository extends JpaRepository<Classes,Integer> {
    Optional<Classes> findByIdAndDeletedAtIsNull(Integer id);
}
