package tm.integracja.Projekt.integracja.currencyscoop.model;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.Map;

@Value
public class CurrencyData {

    LocalDateTime date;
    String base;
    Map<String, Object> rates;
}
