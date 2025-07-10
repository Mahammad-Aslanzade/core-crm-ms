package az.company.corecrmms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"user\"")
public class User extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private Integer internalNumber;
    private String currentJobId;
    private String password;

    @OneToOne
    @JoinColumn(name = "detail_id")
    private UserDetail detail;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_job",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private List<Job> jobs;

}
