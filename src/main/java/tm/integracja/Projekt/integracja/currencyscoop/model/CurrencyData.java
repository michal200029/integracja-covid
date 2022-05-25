package tm.integracja.Projekt.integracja.currencyscoop.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class CurrencyData {

    LocalDateTime date;
    String base;
    double value;
}
