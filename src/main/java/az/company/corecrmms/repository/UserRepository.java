package az.company.corecrmms.repository;

import az.company.corecrmms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
