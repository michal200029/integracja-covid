package tm.integracja.Projekt.integracja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tm.integracja.Projekt.integracja.entity.Report;

public interface ReportRepository extends JpaRepository<Report, String> {
}
