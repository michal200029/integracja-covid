package tm.integracja.Projekt.integracja.usa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annotations {

    @JsonProperty("source_description")
    public String sourceDescription;
    @JsonProperty("subtopic")
    public String subtopic;
    @JsonProperty("source_name")
    public String sourceName;
    @JsonProperty("topic")
    public String topic;
    @JsonProperty("dataset_name")
    public String datasetName;
    @JsonProperty("dataset_link")
    public String datasetLink;

}
