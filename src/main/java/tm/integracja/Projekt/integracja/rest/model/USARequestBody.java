package tm.integracja.Projekt.integracja.rest.model;

import lombok.Value;

import java.time.LocalDate;

@Value
public class USARequestBody {

    LocalDate startDate;
    LocalDate endDate;

}
