package az.company.corecrmms.repository;

import az.company.corecrmms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByEmailContaining(String email);
}
