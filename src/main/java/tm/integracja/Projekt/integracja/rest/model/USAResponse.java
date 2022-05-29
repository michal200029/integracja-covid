package tm.integracja.Projekt.integracja.rest.model;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class USAResponse {

    LocalDate date;

    BigDecimal employees;

}
