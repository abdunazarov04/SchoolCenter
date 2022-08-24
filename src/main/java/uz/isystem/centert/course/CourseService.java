package uz.isystem.centert.course;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.isystem.centert.exeption.ServerBadRequestException;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;

    public Boolean create(CourseDto courseDto) {
       Course course = new Course();
       course.setStatus(true);
       course.setCreatedAt(LocalDateTime.now());
       courseRepository.save(course);
       return true;
    }

    public CourseDto get(Integer id) {
        Course course = getEntity(id);
        CourseDto courseDto = new CourseDto();
        convertDtoEntity(courseDto,course);
        return courseDto;
    }

    public Boolean update(Integer id, CourseDto courseDto) {
        Course course = getEntity(id);
        course.setUpdateAt(LocalDateTime.now());
        convertEntityDto(course,courseDto);
        courseRepository.save(course);
        return true;
    }

    public Boolean delete(Integer id) {
       Course course = getEntity(id);
       course.setDeletedAt(LocalDateTime.now());
       courseRepository.save(course);
       return true;
    }

    private void convertDtoEntity(CourseDto courseDto, Course course){
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDisplayName(course.getDisplayName());
    }

    private void convertEntityDto(Course course, CourseDto courseDto){
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        course.setDisplayName(course.getDisplayName());
    }

    public Course getEntity(Integer id) {
        Optional<Course> optional = courseRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            throw new ServerBadRequestException("Course not found");
        }
        return optional.get();
    }
}
