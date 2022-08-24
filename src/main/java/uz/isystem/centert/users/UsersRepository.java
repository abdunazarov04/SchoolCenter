package uz.isystem.centert.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByEmailAndDeletedAtIsNull(String username);

    Optional<Users> findByIdAndDeletedAtIsNull(Integer id);
    Optional<Users> findByEmailOrPhoneAndDeletedAtIsNull(String email, String contact);
    Optional<Users> findByEmailAndPasswordAndDeletedAtIsNull(String email, String generateMD5);
}
