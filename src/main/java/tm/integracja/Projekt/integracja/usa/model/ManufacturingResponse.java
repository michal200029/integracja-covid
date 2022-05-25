package tm.integracja.Projekt.integracja.usa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturingResponse {

    @JsonProperty("data")
    public List<ManufacturingEmployment> data;
    @JsonProperty("source")
    public List<Source> source;

}
