package tm.integracja.Projekt.integracja.cryptocurrency.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @SerializedName("604800")
    @Expose
    List<List<BigDecimal>> rates;

    /**
     *
     * [
     *   CloseTime,
     *   OpenPrice,
     *   HighPrice,
     *   LowPrice,
     *   ClosePrice,
     *   Volume,
     *   QuoteVolume
     * ]
     *
     *
     */
}
