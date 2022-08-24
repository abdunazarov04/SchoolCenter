package uz.isystem.centert.userGroups;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/user-groups")
@AllArgsConstructor
    public class UserGroupsController {
        private UserGroupsService userGroupsService;

        @GetMapping("/get/{id}")
        public ResponseEntity<?> getUserGroup(@PathVariable("id") Integer id){
            UserGroupsDto userGroupsDto = userGroupsService.get(id);
            return ResponseEntity.ok(userGroupsDto);
        }

        @PostMapping("/create")
        public ResponseEntity<?> createUserGroup(@RequestBody @Valid UserGroupsDto userGroupsDto){
           Boolean result = userGroupsService.create(userGroupsDto);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateUserGroup(
                @PathVariable ("id") @Valid Integer id,
                @RequestBody UserGroupsDto userGroupsDto
        ){
            Boolean result = userGroupsService.update(id,userGroupsDto);
            return ResponseEntity.ok(result);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteUserGroup(
                @PathVariable ("id") Integer id
        ){
            Boolean result = userGroupsService.delete(id);
            return ResponseEntity.ok(result);
        }
}
