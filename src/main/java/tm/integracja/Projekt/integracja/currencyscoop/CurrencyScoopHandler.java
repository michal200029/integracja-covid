package tm.integracja.Projekt.integracja.currencyscoop;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tm.integracja.Projekt.integracja.currencyscoop.model.HistoricalCurrencyValuesRequestBody;
import tm.integracja.Projekt.integracja.currencyscoop.model.HistoricalCurrencyValuesResponse;


@RestController
@AllArgsConstructor
public class CurrencyScoopHandler {

    private final CurrencyScoopClient currencyScoopClient;

    @PostMapping("/test")
    public HistoricalCurrencyValuesResponse getHistoricalValues(@RequestBody HistoricalCurrencyValuesRequestBody body) {
        String apiKey = "e7030b0681415d2697a7f7b751476df0";
        currencyScoopClient.getHistoricalCurrencyValue();
        return null;

    }



}
