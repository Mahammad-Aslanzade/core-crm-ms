package az.company.corecrmms.repository;

import az.company.corecrmms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    boolean existsByName(String name);
    boolean existsByShortName(String shorName);
    boolean existsByHotCallNumber(String hotCallNumber);
}
