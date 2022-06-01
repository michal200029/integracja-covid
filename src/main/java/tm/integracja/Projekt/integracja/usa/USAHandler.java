package tm.integracja.Projekt.integracja.usa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tm.integracja.Projekt.integracja.raport.ReportGenerator;
import tm.integracja.Projekt.integracja.rest.model.USAData;
import tm.integracja.Projekt.integracja.rest.model.USAResponse;
import tm.integracja.Projekt.integracja.usa.model.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class USAHandler {

    public static final String DAY_OF_MONTH = "01";
    public static final int MANUFACTURING_SECTOR = 30;
    public static final int TRANSPORTATION_SECTOR = 40;
    public static final int LEISURE_SECTOR = 70;
    private final USAClient manufacturingClient;
    private final ReportGenerator reportGenerator;


    public USAResponse getHistoricalManufacturingData(LocalDate startDate, LocalDate endDate) {
        return getManufacturingEmployment(startDate, endDate, MANUFACTURING_SECTOR);
    }

    public USAResponse getHistoricalTransportationData(LocalDate startDate, LocalDate endDate) {
        return getManufacturingEmployment(startDate, endDate, TRANSPORTATION_SECTOR);
    }

    public USAResponse getHistoricalLeisureData(LocalDate startDate, LocalDate endDate) {
        return getManufacturingEmployment(startDate, endDate, LEISURE_SECTOR);
    }

    private USAResponse getManufacturingEmployment(LocalDate startDate, LocalDate endDate, Integer sector) {
        List<USAData> response = new ArrayList<>();

        //Dodaje/odejmuje miesiac zeby metody isAfter/isBefore
        //zlapaly te miesiace, bo bez tego sa pomijane
        LocalDate finalStartDate = startDate.minusMonths(1);
        LocalDate finalEndDate = endDate.plusMonths(1);

        double minValue = Double.MAX_VALUE;
        double maxValue = 0;
        double sum = 0;

        List<Data> employees = manufacturingClient.readManufacturingEmployment(
                "BLS Employment - Supersector Only",
                "Month of Year,Supersector",
                "NSA Employees",
                sector
        ).getData();

        for (Data employee: employees) {
            String date = employee.getMonthOfYearID() + "-" + DAY_OF_MONTH;
            LocalDate formatedDate = LocalDate.parse(date);
            if (formatedDate.isAfter(finalStartDate) && formatedDate.isBefore(finalEndDate)) {
                double value = employee.getNSAEmployees().toBigInteger().doubleValue();

                sum += value;
                if (value > maxValue)
                    maxValue = value;
                if (value < minValue)
                    minValue = value;

                response.add(new USAData(formatedDate, BigDecimal.valueOf(value).setScale(0))
                );
            }
        }

        reportGenerator.generateAndSaveReport(startDate, endDate, minValue, maxValue, sum, response.size());
        return new USAResponse(response);
    }


}
