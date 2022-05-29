package tm.integracja.Projekt.integracja.cryptocurrency;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.integracja.Projekt.integracja.rest.model.CurrencyData;
import tm.integracja.Projekt.integracja.rest.model.HistoricalCurrencyValuesResponse;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneId.of;

@RestController
@RequiredArgsConstructor
public class CryptoHandler {

    private final CryptoClient cryptoClient;

    @GetMapping("/krypto")
    public HistoricalCurrencyValuesResponse getHistoricalCryptoValues(String base, LocalDate start, LocalDate end) {
        var res = cryptoClient.getHistoricalCryptoValues(
                base,
                Timestamp.valueOf(start.atStartOfDay().atZone(of("Europe/Paris")).toLocalDateTime()).toInstant().getEpochSecond(),
                Timestamp.valueOf(end.atStartOfDay().atZone(of("Europe/Paris")).toLocalDateTime()).toInstant().getEpochSecond()
                );

        List<CurrencyData> currencyData = new ArrayList<>();

        for (List<BigDecimal> rate : res.getResult().getRates()) {

            var date = new Timestamp(rate.get(0).longValue() * 1000).toLocalDateTime().toLocalDate();

            if (date.getDayOfMonth() > 24 || date.getDayOfMonth() < 8) {
                currencyData.add(new CurrencyData(date, rate.get(4).doubleValue()));
            }
        }

        return new HistoricalCurrencyValuesResponse(base, currencyData);
    }
}
