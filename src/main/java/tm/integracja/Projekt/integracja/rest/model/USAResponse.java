package tm.integracja.Projekt.integracja.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class USAResponse {

    @JsonProperty("data")
    List<USAData> usaData;

}
