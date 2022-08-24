package uz.isystem.centert.attendanceType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.isystem.centert.userGroups.UserGroups;

import java.util.Optional;

@Repository
public interface AttendanceTypeRepository extends JpaRepository<AttendanceType,Integer> {
    Optional<AttendanceType> findByIdAndDeletedAtIsNull(Integer id);
}
