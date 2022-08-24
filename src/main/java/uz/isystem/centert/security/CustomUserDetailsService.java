package uz.isystem.centert.security;

import com.isystem.students.exception.StudentException;
import com.isystem.students.model.Users;
import com.isystem.students.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

//Management (foydalanuchilar boshqaruvi) uchun javob beradigan class
@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optional = usersRepository.findByEmailAndDeletedAtIsNull(username);
        if (optional.isEmpty()) {
            throw new StudentException("User not found");
        }
        Users users = optional.get();
        return new CustomUserDetails(users);
    }
}
