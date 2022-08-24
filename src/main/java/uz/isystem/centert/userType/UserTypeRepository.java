package uz.isystem.centert.userType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.isystem.centert.users.Users;

import java.util.Optional;
@Repository
public interface UserTypeRepository extends JpaRepository<UserTypes,Integer> {
    Optional<UserTypes> findByIdAndDeletedAtIsNull(Integer id);
}
