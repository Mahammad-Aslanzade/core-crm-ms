package az.company.corecrmms.repository;

import az.company.corecrmms.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
}
