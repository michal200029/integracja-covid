package tm.integracja.Projekt.integracja.rest.model;

import lombok.Value;

import java.time.LocalDate;

@Value
public class HistoricalCurrencyValuesRequestBody {
    String base;
    String symbol;
    LocalDate startDate;
    LocalDate endDate;
}
