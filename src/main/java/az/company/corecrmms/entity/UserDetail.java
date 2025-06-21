package az.company.corecrmms.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail extends BaseEntity {

    private String phoneNumber;
    private String address;
    private BigDecimal currentSalary;
    private LocalDate employmentStartDate;
    private LocalDate employmentEndDate;
    private String employmentTerminationReason;
}
