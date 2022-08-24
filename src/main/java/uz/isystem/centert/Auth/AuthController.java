package uz.isystem.centert.Auth;

import com.isystem.students.dto.AuthDto;
import com.isystem.students.dto.RegisterDto;
import com.isystem.students.dto.UsersDto;
import com.isystem.students.model.AuthData;
import com.isystem.students.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto dto){
        AuthData result = authService.register(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthDto dto){
        AuthDto result = authService.login(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/verification/{token}")
    public ResponseEntity<?> verification(@PathVariable("token") String token){
        UsersDto result = authService.verification(token);
        return ResponseEntity.ok(result);
    }
}
