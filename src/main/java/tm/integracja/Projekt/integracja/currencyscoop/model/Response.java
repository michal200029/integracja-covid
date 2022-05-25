package tm.integracja.Projekt.integracja.currencyscoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    String date;
    String base;
    Rates rates;
}