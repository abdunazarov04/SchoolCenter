package uz.isystem.centert.Auth;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

@Service
public class PasswordService {
    public static String generateMD5(String password){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
