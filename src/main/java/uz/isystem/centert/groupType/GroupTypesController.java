package uz.isystem.centert.groupType;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/groupTypes")
@AllArgsConstructor
public class GroupTypesController {
    private GroupTypesService groupTypesService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getGroupTypes(@PathVariable("id") Integer id){
        GroupTypesDto groupTypesDto = groupTypesService.get(id);
        return ResponseEntity.ok(groupTypesDto);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createGroupType(@RequestBody @Valid GroupTypesDto groupTypesDto){
        Boolean result = groupTypesService.create(groupTypesDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGroupTypes(
            @PathVariable ("id") Integer id,
            @RequestBody GroupTypesDto groupTypesDto
    ){
        Boolean result = groupTypesService.update(id,groupTypesDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroupTypes(
            @PathVariable ("id") Integer id
    ){
        Boolean result = groupTypesService.delete(id);
        return ResponseEntity.ok(result);
    }
}
