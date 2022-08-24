package uz.isystem.centert.rooms;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
    @RestController
    @RequestMapping("/api/v1/rooms")
    @AllArgsConstructor

    public class RoomsController {
        private RoomsService roomsService;

        @GetMapping("/get/{id}")
        public ResponseEntity<?> getRooms(@PathVariable("id") Integer id){
            RoomsDto roomsDto = roomsService.get(id);
            return ResponseEntity.ok(roomsDto);
        }

        @PostMapping("/create")
        public ResponseEntity<?> createRooms(@RequestBody @Valid RoomsDto roomsDto){
         Boolean result = roomsService.create(roomsDto);
            return ResponseEntity.ok(result);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateRooms(
                @PathVariable ("id") Integer id,
                @RequestBody RoomsDto roomsDto
        ){
            Boolean result = roomsService.update(id,roomsDto);
            return ResponseEntity.ok(result);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteRooms(
                @PathVariable ("id") Integer id
        ){
            Boolean result = roomsService.delete(id);
            return ResponseEntity.ok(result);
        }

}
