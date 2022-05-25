package tm.integracja.Projekt.integracja.usa.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturingEmployment {

    @JsonProperty("Month of Year ID")
//    public String monthOfYearID;
    public Map<String, String> monthOfYearID;
    @JsonProperty("Month of Year")
    public String monthOfYear;
    @JsonProperty("Supersector ID")
    public String supersectorID;
    @JsonProperty("Supersector")
    public String supersector;
    @JsonProperty("NSA Employees")
    public Double nSAEmployees;

}
