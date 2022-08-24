package uz.isystem.centert.classes;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
@AllArgsConstructor
public class ClassesController {
    private ClassesService classesService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getClasses(@PathVariable("id") Integer id){
        ClassesDto classesDto = classesService.get(id);
        return ResponseEntity.ok(classesDto);
    }

    @PostMapping("/create")
    private ResponseEntity<?> createClasses(@RequestBody @Valid ClassesDto classesDto){
        Boolean result = classesService.create(classesDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClasses(
            @PathVariable ("id") @Valid Integer id,
            @RequestBody ClassesDto classesDto
    ){
        Boolean result = classesService.update(id,classesDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClasses(
            @PathVariable ("id") Integer id
    ){
        Boolean result = classesService.delete(id);
        return ResponseEntity.ok(result);
    }
}
