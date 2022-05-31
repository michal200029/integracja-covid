package tm.integracja.Projekt.integracja.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tm.integracja.Projekt.integracja.rest.model.USARequestBody;
import tm.integracja.Projekt.integracja.rest.model.USAResponse;
import tm.integracja.Projekt.integracja.usa.USAHandler;

@RestController
@RequestMapping(value = "/usa")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class USAController {

    private final USAHandler manufacturingHandler;

    @PostMapping("/manufacturing")
    public USAResponse readManufacturingEmployment(@RequestBody USARequestBody body) {

        return manufacturingHandler.getHistoricalManufacturingData(body.getStartDate(), body.getEndDate());

    }

    @PostMapping("/transportation")
    public USAResponse readTransportationEmployment(@RequestBody USARequestBody body) {

        return manufacturingHandler.getHistoricalTransportationData(body.getStartDate(), body.getEndDate());

    }

    @PostMapping("/leisure")
    public USAResponse readLeisureEmployment(@RequestBody USARequestBody body) {

        return manufacturingHandler.getHistoricalLeisureData(body.getStartDate(), body.getEndDate());

    }

}
