package az.company.corecrmms.repository;

import az.company.corecrmms.entity.User;
import az.company.corecrmms.entity.UserVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserVerificationRepository extends JpaRepository<UserVerification, String> {
    Optional<UserVerification> findTopByUserAndCreatedAtDesc(User user);
}
