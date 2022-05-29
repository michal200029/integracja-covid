package tm.integracja.Projekt.integracja.usa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Source {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("measures")
    @Expose
    public List<String> measures = null;
    @SerializedName("annotations")
    @Expose
    public Annotations annotations;


}
