package tm.integracja.Projekt.integracja.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SubBranch {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

}
