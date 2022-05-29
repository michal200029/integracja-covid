package tm.integracja.Projekt.integracja.cryptocurrency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CryptoResponse {

    private Result result;

    List<BigDecimal> convert() {
        return result.getRates().stream().map(res -> res.get(0)).collect(Collectors.toList());
    }

}
