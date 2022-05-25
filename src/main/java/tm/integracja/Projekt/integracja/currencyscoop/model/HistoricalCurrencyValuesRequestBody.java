package tm.integracja.Projekt.integracja.currencyscoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricalCurrencyValuesRequestBody {
    String base;
    String symbol;
    String date;
}
