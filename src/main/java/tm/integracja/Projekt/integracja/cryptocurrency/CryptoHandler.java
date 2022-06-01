package tm.integracja.Projekt.integracja.cryptocurrency;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.integracja.Projekt.integracja.raport.ReportGenerator;
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
    private final ReportGenerator reportGenerator;

    @GetMapping("/krypto")
    public HistoricalCurrencyValuesResponse getHistoricalCryptoValues(String base, LocalDate start, LocalDate end) {
        var res = cryptoClient.getHistoricalCryptoValues(
                base,
                Timestamp.valueOf(start.atStartOfDay().atZone(of("Europe/Paris")).toLocalDateTime()).toInstant().getEpochSecond(),
                Timestamp.valueOf(end.atStartOfDay().atZone(of("Europe/Paris")).toLocalDateTime()).toInstant().getEpochSecond()
                );

        List<CurrencyData> currencyData = new ArrayList<>();

        double minValue = Double.MAX_VALUE;
        double maxValue = 0;
        double sum = 0;

        for (List<BigDecimal> rate : res.getResult().getRates()) {

            var date = new Timestamp(rate.get(0).longValue() * 1000).toLocalDateTime().toLocalDate();

            if (date.getDayOfMonth() > 24 || date.getDayOfMonth() < 8) {
                double value = rate.get(4).doubleValue();

                sum += value;
                if (value > maxValue)
                    maxValue = value;
                if (value < minValue)
                    minValue = value;

                currencyData.add(new CurrencyData(date, rate.get(4).doubleValue()));
            }
        }

        reportGenerator.generateAndSaveReport(start, end, minValue, maxValue, sum, currencyData.size());
        return new HistoricalCurrencyValuesResponse(base, currencyData);
    }
}
