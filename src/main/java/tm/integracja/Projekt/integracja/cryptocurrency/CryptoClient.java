package tm.integracja.Projekt.integracja.cryptocurrency;

import feign.Param;
import feign.RequestLine;
import tm.integracja.Projekt.integracja.cryptocurrency.model.CryptoResponse;

public interface CryptoClient {

    @RequestLine("GET /{base}usd/ohlc?before={end}&after={start}&periods=604800")
    CryptoResponse getHistoricalCryptoValues(
            @Param("base") String base,
            @Param("start") long start,
            @Param("end") long end
    );
}
