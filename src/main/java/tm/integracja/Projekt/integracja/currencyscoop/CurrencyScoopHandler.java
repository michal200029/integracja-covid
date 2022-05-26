package tm.integracja.Projekt.integracja.currencyscoop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tm.integracja.Projekt.integracja.currencyscoop.model.HistoricalResponse;
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
    private final static String PLN = "PLN";
    private final static String WALUTY = "Waluty";

    public HistoricalCurrencyValuesResponse getHistoricalValues(String base, String symbol, LocalDate start, LocalDate end) {

        final String API_KEY = branchRepository.getApiKey(WALUTY);

        LocalDate processingDate = start;
        boolean plusMonth = false;
        List<HistoricalResponse> historicalResponseList = new ArrayList<>();

        while (processingDate != end) {
            String date = String.format("%s-%s-%s",
                    processingDate.getYear(),
                    String.format("%02d", processingDate.getMonthValue()),
                    String.format("%02d", processingDate.getDayOfMonth()));
            historicalResponseList.add(currencyScoopClient.getHistoricalCurrencyValue(API_KEY, base, symbol, date));

            processingDate = plusMonth  ? end.withDayOfMonth(15) : end.withDayOfMonth(1).plusMonths(1);
            plusMonth = !plusMonth;
        }

        List<CurrencyData> currencyData = new ArrayList<>();

        for (final HistoricalResponse hr : historicalResponseList) {
            currencyData.add(new CurrencyData(
                    LocalDate.parse(hr.getResponse().getDate()), hr.getResponse().getRates().get(PLN)));
        }

        return new HistoricalCurrencyValuesResponse(base, currencyData);
    }



}
