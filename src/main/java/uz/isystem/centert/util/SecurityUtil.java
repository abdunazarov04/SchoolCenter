package uz.isystem.s.students.util;

import com.isystem.students.configuration.CustomUserDetails;
import com.isystem.students.exception.StudentException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static Integer getUserId() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            return userDetails.getId();
        }catch (Exception e){
            e.printStackTrace();
            throw new StudentException("class SecurityUtil -> Error");
        }
    }

    public static String get(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
