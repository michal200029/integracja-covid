package tm.integracja.Projekt.integracja.raport;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tm.integracja.Projekt.integracja.entity.Report;
import tm.integracja.Projekt.integracja.repository.ReportRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class ReportGenerator {

    private final ReportRepository reportRepository;

    @Transactional
    public void generateAndSaveReport(
            LocalDate startDate,
            LocalDate endDate,
            Double minValue,
            Double maxValue,
            Double sum,
            int size
    ) {
        String path = "raport_" + LocalDateTime.now();
        reportRepository.save(
                new Report(
                        path,
                        minValue,
                        maxValue,
                        sum/size,
                        maxValue - minValue,
                        startDate,
                        endDate
                )
        );
    }
}
