package uz.isystem.centert.users;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
    @RestController
    @RequestMapping("/api/v1/users")
    @AllArgsConstructor
    public class UsersController {
        private UsersService userService;

        @GetMapping("/{id}")
        public ResponseEntity<?> getUser(@PathVariable("id") Integer id){
            UsersDto userDto = userService.get(id);
            return ResponseEntity.ok(userDto);
        }

        @PostMapping("/create")
        public ResponseEntity<?> createUser(@RequestBody @Valid UsersDto userDto){
           Boolean result = userService.create(userDto);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateUser(
                @PathVariable ("id") Integer id,
                @RequestBody @Valid UsersDto userDto
        ){
            Boolean result =  userService.update(id,userDto);
            return ResponseEntity.ok(result);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteUser(
                @PathVariable ("id") Integer id
        ){
            Boolean result = userService.delete(id);
            return ResponseEntity.ok(result);
        }
}
