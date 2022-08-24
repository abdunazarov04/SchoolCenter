package uz.isystem.centert.userType;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
    @RestController
    @RequestMapping("/api/v1/userType")
    @AllArgsConstructor
    public class UserTypeController {
        private UserTypeService userTypeService;

        @GetMapping("/{id}")
        public ResponseEntity<?> getUserType(@PathVariable("id") Integer id){
            UserTypeDto userTypeDto = userTypeService.get(id);
            return ResponseEntity.ok(userTypeDto);
        }

        @PostMapping
        public ResponseEntity<?> createUserType(@RequestBody @Valid UserTypeDto userTypeDto){
           Boolean result = userTypeService.create(userTypeDto);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateUserType(
                @PathVariable ("id") Integer id,
                @RequestBody UserTypeDto userTypeDto
        ){
            Boolean result = userTypeService.update(id,userTypeDto);
            return ResponseEntity.ok(result);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteUserType(
                @PathVariable ("id") Integer id
        ){
            Boolean result = userTypeService.delete(id);
            return ResponseEntity.ok(result);
        }
}
