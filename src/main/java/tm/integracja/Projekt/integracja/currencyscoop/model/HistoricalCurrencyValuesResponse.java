package tm.integracja.Projekt.integracja.currencyscoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricalCurrencyValuesResponse {

    private List<CurrencyData> currencyData;

}
