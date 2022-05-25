package tm.integracja.Projekt.integracja.usa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Source {

    @JsonProperty("name")
    public String name;
    @JsonProperty("measures")
    public List<String> measures = null;
    @JsonProperty("annotations")
    public Annotations annotations;

}
