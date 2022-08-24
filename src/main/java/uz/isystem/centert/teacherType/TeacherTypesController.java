package uz.isystem.centert.teacherType;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
    @RestController
    @RequestMapping("/api/v1/teachers")
    @AllArgsConstructor
    public class TeacherTypesController {
        private TeacherTypesService teacherTypesService;

        @GetMapping("/get/{id}")
        public ResponseEntity<?> getTeacherType(@PathVariable("id") Integer id){
            TeacherTypesDto teacherTypesDto = teacherTypesService.get(id);
            return ResponseEntity.ok(teacherTypesDto);
        }

        @PostMapping("/create")
        public ResponseEntity<?> createTeacherType(@RequestBody @Valid TeacherTypesDto teacherTypesDto){
            Boolean result = teacherTypesService.create(teacherTypesDto);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateTeacherType(
                @PathVariable ("id") Integer id,
                @RequestBody TeacherTypesDto teacherTypesDto
        ){
            Boolean result = teacherTypesService.update(id,teacherTypesDto);
            return ResponseEntity.ok(result);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteTeacherType(
                @PathVariable ("id") Integer id
        ){
            Boolean result = teacherTypesService.delete(id);
            return ResponseEntity.ok(result);
        }
}
