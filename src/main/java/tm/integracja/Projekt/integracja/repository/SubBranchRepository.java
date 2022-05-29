package tm.integracja.Projekt.integracja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tm.integracja.Projekt.integracja.entity.SubBranch;

import java.util.List;

@Repository
public interface SubBranchRepository extends JpaRepository<SubBranch, Long> {

    List<SubBranch> findByBranchId(long branchId);
}
