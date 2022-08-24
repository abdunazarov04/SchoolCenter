package uz.isystem.centert.attendanceType;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/attendance-types")
@AllArgsConstructor
public class AttendanceTypeController {
    private AttendanceTypeService attendanceTypeService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAttendance(@PathVariable("id") Integer id){
        AttendanceTypeDto attendanceTypeDto = attendanceTypeService.get(id);
        return ResponseEntity.ok(attendanceTypeDto);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAttendance(@RequestBody @Valid AttendanceTypeDto attendanceTypeDto){
       Boolean result = attendanceTypeService.create(attendanceTypeDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAttendance(
            @PathVariable ("id") Integer id,
            @RequestBody AttendanceTypeDto attendanceTypeDto
    ){
      Boolean result =   attendanceTypeService.update(id,attendanceTypeDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAttendance(
            @PathVariable ("id") Integer id
    ){
       Boolean result = attendanceTypeService.delete(id);
        return ResponseEntity.ok(result);
    }
}
