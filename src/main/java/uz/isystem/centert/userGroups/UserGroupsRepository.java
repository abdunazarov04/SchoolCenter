package uz.isystem.centert.userGroups;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserGroupsRepository  extends JpaRepository<UserGroups,Integer> {
    Optional<UserGroups> findByIdAndDeletedAtIsNull(Integer id);
}
