package uz.isystem.centert.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Optional<Course> findByIdAndDeletedAtIsNull(Integer id);
}
