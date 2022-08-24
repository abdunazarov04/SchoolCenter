package uz.isystem.centert.course;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
    @RestController
    @RequestMapping("/api/v1/courses")
    @AllArgsConstructor
    public class CourseController {
        private CourseService courseService;

        @GetMapping("/get/{id}")
        public ResponseEntity<?> getCourse(@PathVariable("id") Integer id){
            CourseDto courseDto = courseService.get(id);
            return ResponseEntity.ok(courseDto);
        }

        @PostMapping("/create")
        public ResponseEntity<?> createCourse(@RequestBody @Valid CourseDto courseDto){
            Boolean result = courseService.create(courseDto);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateCourse(
                @PathVariable ("id") @Valid Integer id,
                @RequestBody CourseDto courseDto
        ){
            Boolean result = courseService.update(id,courseDto);
            return ResponseEntity.ok(result);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteCourse(
                @PathVariable ("id") Integer id
        ){
            Boolean result = courseService.delete(id);
            return ResponseEntity.ok(result);
        }
}
