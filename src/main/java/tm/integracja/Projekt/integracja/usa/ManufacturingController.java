package tm.integracja.Projekt.integracja.usa;

import feign.Feign;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tm.integracja.Projekt.integracja.config.FeignConfig;
import tm.integracja.Projekt.integracja.usa.model.ManufacturingResponse;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/manufacturing")
@AllArgsConstructor
public class ManufacturingController {

    private final ManufacturingClient manufacturingClient;

    @GetMapping
    public ManufacturingResponse readManufacturingEmployment() {

        Map<String, Object> params = new LinkedHashMap<>();
        params.put("cube", "BLS Employment - Supersector Only");
        params.put("drilldowns", "Month of Year,Supersector");
        params.put("measures", "NSA Employees");
        params.put("supersector", 30);


        manufacturingClient.readManufacturingEmployment(
                (String) params.get("cube"),
                (String) params.get("drilldowns"),
                (String) params.get("measures"),
                (Integer) params.get("supersector")
        );
        return null;

    }

}
