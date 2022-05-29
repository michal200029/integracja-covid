package tm.integracja.Projekt.integracja.usa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class USAApiResponse {

    @SerializedName("data")
    @Expose
    public List<Data> data = null;
    @SerializedName("source")
    @Expose
    public List<Source> source = null;

}
