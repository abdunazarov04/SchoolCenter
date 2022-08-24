package uz.isystem.centert.teacher;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/teacher")
@AllArgsConstructor
    public class TeacherController {
        private TeacherService teacherService;

        @GetMapping("/get/{id}")
        public ResponseEntity<?> getTeacher(@PathVariable("id") Integer id){
            TeacherDto teacherDto = teacherService.get(id);
            return ResponseEntity.ok(teacherDto);
        }

        @PostMapping("/create")
        public ResponseEntity<?> createTeacher(@RequestBody @Valid TeacherDto teacherDto){
           Boolean result = teacherService.create(teacherDto);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateTeacher(
                @PathVariable ("id") Integer id,
                @RequestBody @Valid TeacherDto teacherDto
        ){
            Boolean result = teacherService.update(id,teacherDto);
            return ResponseEntity.ok(result);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteTeacher(
                @PathVariable ("id") Integer id
        ){
            Boolean result = teacherService.delete(id);
            return ResponseEntity.ok(result);
        }
}
