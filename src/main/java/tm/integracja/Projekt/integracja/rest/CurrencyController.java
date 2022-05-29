package tm.integracja.Projekt.integracja.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tm.integracja.Projekt.integracja.cryptocurrency.CryptoHandler;
import tm.integracja.Projekt.integracja.currencyscoop.CurrencyScoopHandler;
import tm.integracja.Projekt.integracja.rest.model.HistoricalCurrencyValuesRequestBody;
import tm.integracja.Projekt.integracja.rest.model.HistoricalCurrencyValuesResponse;

@RestController
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyScoopHandler currencyScoopHandler;
    private final CryptoHandler cryptoHandler;

    @PostMapping("/currency")
    public HistoricalCurrencyValuesResponse getHistoricalCurrencyValues(@RequestBody HistoricalCurrencyValuesRequestBody body) {
        return currencyScoopHandler.getHistoricalValues(
                body.getBase().toLowerCase(),
                body.getStartDate(),
                body.getEndDate()
        );
    }

    @PostMapping("/crypto")
    public HistoricalCurrencyValuesResponse getHistoricalCryptoValues(@RequestBody HistoricalCurrencyValuesRequestBody body) {
        return cryptoHandler.getHistoricalCryptoValues(
                body.getBase().toLowerCase(),
                body.getStartDate(),
                body.getEndDate()
        );
    }
}
