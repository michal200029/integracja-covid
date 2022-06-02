package tm.integracja.Projekt.integracja.rest.model;

import lombok.Value;

import java.util.List;

@Value
public class BranchResponse {

    String name;
    List<String> subbranches;

}
