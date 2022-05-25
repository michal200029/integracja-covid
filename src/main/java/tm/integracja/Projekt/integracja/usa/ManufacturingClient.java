package tm.integracja.Projekt.integracja.usa;

import feign.Param;
import feign.RequestLine;
import tm.integracja.Projekt.integracja.usa.model.ManufacturingResponse;

public interface ManufacturingClient {

    @RequestLine("GET ?cube={cube}&drilldowns={drilldowns}&measures={measures}&Supersector={sector}")
    ManufacturingResponse readManufacturingEmployment(
            @Param(value = "cube") String cube,
            @Param(value = "drilldowns") String drilldowns,
            @Param(value = "measures") String measures,
            @Param(value = "sector") Integer sector
    );

}
