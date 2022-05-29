package tm.integracja.Projekt.integracja.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.integracja.Projekt.integracja.rest.model.USARequestBody;
import tm.integracja.Projekt.integracja.rest.model.USAResponse;
import tm.integracja.Projekt.integracja.usa.USAHandler;

import java.util.List;

@RestController
@RequestMapping(value = "/usa")
@AllArgsConstructor
public class USAController {

    private final USAHandler manufacturingHandler;

    @GetMapping("/manufacturing")
    public List<USAResponse> readManufacturingEmployment(@RequestBody USARequestBody body) {

        return manufacturingHandler.getHistoricalManufacturingData(body.getStartDate(), body.getEndDate());

    }

    @GetMapping("/transportation")
    public List<USAResponse> readTransportationEmployment(@RequestBody USARequestBody body) {

        return manufacturingHandler.getHistoricalTransportationData(body.getStartDate(), body.getEndDate());

    }

}
