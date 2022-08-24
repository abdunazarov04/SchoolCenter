package uz.isystem.centert.userImage;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import lombok.AllArgsConstructor;
import uz.isystem.centert.exeption.ServerBadRequestException;

import java.io.IOException;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/image")
public class UserImageController {
    private UserImageService userImageService;

    @PostMapping("/create")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
        ImageDto result = userImageService.saveToSystem(file);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/load/{filename:.+}")
    public @ResponseBody ResponseEntity<?> saveFile(@PathVariable String filename) throws IOException {
        Resource file = userImageService.load(filename);
        return ResponseEntity.ok().header("Content-Disposition",
                "attachment; filename=" + "image.png").body(file);
    }

    @GetMapping(value = "/get/{link:.+}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getImage(@PathVariable("link") String link) {
        if (link != null && link.length() > 0) {
            try {
                return userImageService.getImg(link);
            } catch (Exception e) {
                throw new ServerBadRequestException("Image not found");
            }
        }
        return null;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        ImageDto result = userImageService.get(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = userImageService.delete(id);
        return ResponseEntity.ok(result);
    }

}
