package tm.integracja.Projekt.integracja.usa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annotations {

    @SerializedName("source_description")
    @Expose
    public String sourceDescription;
    @SerializedName("subtopic")
    @Expose
    public String subtopic;
    @SerializedName("source_name")
    @Expose
    public String sourceName;
    @SerializedName("topic")
    @Expose
    public String topic;
    @SerializedName("dataset_name")
    @Expose
    public String datasetName;
    @SerializedName("dataset_link")
    @Expose
    public String datasetLink;

}
