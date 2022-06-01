package tm.integracja.Projekt.integracja.raport;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tm.integracja.Projekt.integracja.repository.ReportRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
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
        double avg = sum/size;
        double amp = maxValue - minValue;

        reportRepository.save(
                new tm.integracja.Projekt.integracja.entity.Report(path, minValue, maxValue, avg, amp, startDate, endDate)
        );

        Report report = new Report(minValue, maxValue, avg, amp, startDate.toString(), endDate.toString());

        File file = new File("raport.xml");
        final JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Report.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(report, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
