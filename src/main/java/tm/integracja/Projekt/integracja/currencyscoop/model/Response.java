package tm.integracja.Projekt.integracja.currencyscoop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    String date;
    String base;
    Map<String, Double> rates;
}