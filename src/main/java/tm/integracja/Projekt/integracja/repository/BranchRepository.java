package tm.integracja.Projekt.integracja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import tm.integracja.Projekt.integracja.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    @Query("SELECT b.apiKey FROM Branch b where b.name = :name")
    String getApiKey(String name);
}
