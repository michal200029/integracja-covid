package tm.integracja.Projekt.integracja.currencyscoop;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.integracja.Projekt.integracja.currencyscoop.model.HistoricalCurrencyValuesResponse;

import java.time.LocalDate;


@RestController
@AllArgsConstructor
public class CurrencyScoopHandler {

    private final CurrencyScoopClient currencyScoopClient;

    @PostMapping("/test")
    public HistoricalCurrencyValuesResponse getHistoricalValues(String base, String symbol, LocalDate localDate) {
        String apiKey = "e7030b0681415d2697a7f7b751476df0";
        String date = String.format("%s-%s-%s",
                localDate.getYear(),
                String.format("%02d", localDate.getMonthValue()),
                String.format("%02d", localDate.getDayOfMonth()));
        currencyScoopClient.getHistoricalCurrencyValue(apiKey, base, symbol, date);
        return null;

    }



}
