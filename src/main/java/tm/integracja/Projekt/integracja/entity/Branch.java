package tm.integracja.Projekt.integracja.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "branch")
@Entity
public class Branch {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "branch")
    private Set<SubBranch> subBranches;
}
