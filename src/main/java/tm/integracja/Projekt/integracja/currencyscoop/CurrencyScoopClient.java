package tm.integracja.Projekt.integracja.currencyscoop;

import feign.Param;
import feign.RequestLine;
import tm.integracja.Projekt.integracja.currencyscoop.model.HistoricalResponse;


public interface CurrencyScoopClient {

    @RequestLine("GET /historical?api_key={api_key}&base={base}&symbols={symbol}&date={date}")
    HistoricalResponse getHistoricalCurrencyValue(
            @Param("api_key") String apiKey,
            @Param("base") String base,
            @Param("symbol") String symbol,
            @Param("date") String date
    );
}


