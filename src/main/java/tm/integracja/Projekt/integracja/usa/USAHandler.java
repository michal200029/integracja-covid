package tm.integracja.Projekt.integracja.usa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tm.integracja.Projekt.integracja.rest.model.USAResponse;

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
    private final USAClient manufacturingClient;


    public List<USAResponse> getHistoricalManufacturingData(LocalDate startDate, LocalDate endDate) {
        return getManufacturingEmployment(startDate, endDate, MANUFACTURING_SECTOR);
    }

    public List<USAResponse> getHistoricalTransportationData(LocalDate startDate, LocalDate endDate) {
        return getManufacturingEmployment(startDate, endDate, TRANSPORTATION_SECTOR);
    }

    private List<USAResponse> getManufacturingEmployment(LocalDate startDate, LocalDate endDate, Integer sector) {
        List<USAResponse> response = new ArrayList<>();

        manufacturingClient.readManufacturingEmployment(
                        "BLS Employment - Supersector Only",
                        "Month of Year,Supersector",
                        "NSA Employees",
                        sector
                ).data
                .forEach(manufacturingEmployment -> {
                    String date = manufacturingEmployment.getMonthOfYearID() + "-" + DAY_OF_MONTH;
                    LocalDate formatedDate = LocalDate.parse(date);
                    if (formatedDate.isAfter(startDate) && formatedDate.isBefore(endDate)) {
                        response.add(new USAResponse(
                                formatedDate,
                                manufacturingEmployment.getNSAEmployees())
                        );
                    }
                });

        return response;
    }


}
