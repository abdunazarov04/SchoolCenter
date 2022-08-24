package uz.isystem.s.students.util;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    private final Path root = Paths.get("images");

    public ResponseEntity<MessageResponse> checkAndSaveImage(MultipartFile image){
        if(checkFileType(image.getContentType())) {
            try {
                Files.copy(image.getInputStream(), this.root.resolve(image.hashCode() + ".jpg"));
                return ResponseEntity.status(200).body(new MessageResponse("OK"));
            } catch (IOException e) {
                System.out.print(e.getMessage());
                return ResponseEntity.status(500).body(new MessageResponse("ERROR"));
            }
        }
        return ResponseEntity.status(500).body(new MessageResponse("FILE TYPE NOT FITS"));
    }

    public boolean checkFileType(String type) {
        if (!(type.equalsIgnoreCase("image/jpg")
                || type.equalsIgnoreCase("image/jpeg")
                || type.equalsIgnoreCase("image/png"))) {
            return false;
        }
        return true;
    }

    public void deleteByAddress(String imageAddress){
        new File("images\\" + imageAddress).delete();
    }
}
