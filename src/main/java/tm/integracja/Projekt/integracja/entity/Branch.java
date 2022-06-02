package tm.integracja.Projekt.integracja.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "api_key")
    private String apiKey;

    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER)
    private Set<SubBranch> subBranches;
}
