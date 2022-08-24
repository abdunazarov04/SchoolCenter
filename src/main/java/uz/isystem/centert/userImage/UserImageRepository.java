package uz.isystem.centert.userImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserImageRepository extends JpaRepository<UserImage,Integer> {
    Optional<UserImage> findByToken(String token);

    Optional<UserImage> findByIdAndDeletedAtIsNull(Integer id);
}
