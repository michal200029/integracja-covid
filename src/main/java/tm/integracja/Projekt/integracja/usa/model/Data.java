package tm.integracja.Projekt.integracja.usa.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    @SerializedName("Month of Year ID")
    @Expose
    public String monthOfYearID;
    @SerializedName("Month of Year")
    @Expose
    public String monthOfYear;
    @SerializedName("Supersector ID")
    @Expose
    public String supersectorID;
    @SerializedName("Supersector")
    @Expose
    public String supersector;
    @SerializedName("NSA Employees")
    @Expose
    public BigDecimal nSAEmployees;

}
