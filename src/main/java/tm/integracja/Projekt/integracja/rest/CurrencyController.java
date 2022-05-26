package tm.integracja.Projekt.integracja.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tm.integracja.Projekt.integracja.currencyscoop.CurrencyScoopHandler;
import tm.integracja.Projekt.integracja.rest.model.HistoricalCurrencyValuesRequestBody;
import tm.integracja.Projekt.integracja.rest.model.HistoricalCurrencyValuesResponse;

@RestController("/currency")
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyScoopHandler currencyScoopHandler;

    @PostMapping()
    public HistoricalCurrencyValuesResponse getHistoricalCurrencyValues(@RequestBody HistoricalCurrencyValuesRequestBody body) {
        return currencyScoopHandler.getHistoricalValues(
                body.getBase(),
                body.getSymbol(),
                body.getStartDate(),
                body.getEndDate()
        );
    }
}
