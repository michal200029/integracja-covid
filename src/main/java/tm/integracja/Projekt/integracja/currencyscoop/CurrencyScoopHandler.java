package tm.integracja.Projekt.integracja.currencyscoop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tm.integracja.Projekt.integracja.currencyscoop.model.HistoricalResponse;
import tm.integracja.Projekt.integracja.raport.ReportGenerator;
import tm.integracja.Projekt.integracja.repository.BranchRepository;
import tm.integracja.Projekt.integracja.rest.model.CurrencyData;
import tm.integracja.Projekt.integracja.rest.model.HistoricalCurrencyValuesResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyScoopHandler {

    private final CurrencyScoopClient currencyScoopClient;
    private final BranchRepository branchRepository;
    private final ReportGenerator reportGenerator;
    private final static String PLN = "PLN";
    private final static String WALUTY = "Waluty";

    public HistoricalCurrencyValuesResponse getHistoricalValues(String base, LocalDate start, LocalDate end) {

        final String API_KEY = branchRepository.getApiKey(WALUTY);

        LocalDate processingDate = start;
        List<HistoricalResponse> historicalResponseList = new ArrayList<>();

        while (processingDate.isBefore(end)) {
            String date = String.format("%s-%s-%s",
                    processingDate.getYear(),
                    String.format("%02d", processingDate.getMonthValue()),
                    String.format("%02d", processingDate.getDayOfMonth()));
            historicalResponseList.add(currencyScoopClient.getHistoricalCurrencyValue(API_KEY, base, PLN, date));

            processingDate = processingDate.withDayOfMonth(1).plusMonths(1);
        }

        double minValue = Double.MAX_VALUE;
        double maxValue = 0;
        double sum = 0;
        List<CurrencyData> currencyData = new ArrayList<>();

        for (final HistoricalResponse hr : historicalResponseList) {
            double value = hr.getResponse().getRates().get(PLN);

            sum += value;
            if (value > maxValue)
                maxValue = value;
            if (value < minValue)
                minValue = value;

            currencyData.add(new CurrencyData(LocalDate.parse(hr.getResponse().getDate()), value));
        }
        reportGenerator.generateAndSaveReport(start, end, minValue, maxValue, sum, historicalResponseList.size());
        return new HistoricalCurrencyValuesResponse(base, currencyData);
    }



}
