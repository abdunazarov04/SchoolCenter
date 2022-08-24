package uz.isystem.centert.group;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/group")
public class GroupController {

    private GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid GroupDto dto){
        Boolean result = groupService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        GroupDto result = groupService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid GroupDto dto){
        Boolean result = groupService.update(id,dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        Boolean result = groupService.delete(id);
        return ResponseEntity.ok(result);
    }
}
