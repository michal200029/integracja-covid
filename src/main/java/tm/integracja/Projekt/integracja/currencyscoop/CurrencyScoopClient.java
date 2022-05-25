package tm.integracja.Projekt.integracja.currencyscoop;

import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestParam;
import tm.integracja.Projekt.integracja.currencyscoop.model.HistoricalResponse;


public interface CurrencyScoopClient {

    @RequestLine("GET /historical?api_key=e7030b0681415d2697a7f7b751476df0&base=USD&symbols=PLNP&date=2020-04-01")
    HistoricalResponse getHistoricalCurrencyValue();
}


