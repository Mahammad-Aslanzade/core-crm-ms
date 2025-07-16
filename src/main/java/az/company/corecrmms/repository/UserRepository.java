package az.company.corecrmms.repository;

import az.company.corecrmms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByEmailContainingAndActiveTrue(String email);

    Optional<User> findByIdAndActiveTrue(String userId);

    Optional<User> findByEmail(String email);

}
