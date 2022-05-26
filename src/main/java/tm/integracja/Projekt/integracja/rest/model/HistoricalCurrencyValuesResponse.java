package tm.integracja.Projekt.integracja.rest.model;

import lombok.Value;

import java.util.List;

@Value
public class HistoricalCurrencyValuesResponse {

    private String base;
    private List<CurrencyData> currencyData;

}
