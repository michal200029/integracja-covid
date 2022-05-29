package tm.integracja.Projekt.integracja.usa;

import feign.Param;
import feign.RequestLine;
import tm.integracja.Projekt.integracja.usa.model.USAApiResponse;

public interface USAClient {

    @RequestLine("GET ?cube={cube}&drilldowns={drilldowns}&measures={measures}&Supersector={sector}")
    USAApiResponse readManufacturingEmployment(
            @Param(value = "cube") String cube,
            @Param(value = "drilldowns") String drilldowns,
            @Param(value = "measures") String measures,
            @Param(value = "sector") Integer sector
    );

    @RequestLine("GET ?cube={cube}&drilldowns={drilldowns}&measures={measures}&Supersector={sector}")
    USAApiResponse readTransportationEmployment(
            @Param(value = "cube") String cube,
            @Param(value = "drilldowns") String drilldowns,
            @Param(value = "measures") String measures,
            @Param(value = "sector") Integer sector
    );

}
