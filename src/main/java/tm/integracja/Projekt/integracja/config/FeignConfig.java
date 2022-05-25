package tm.integracja.Projekt.integracja.config;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tm.integracja.Projekt.integracja.currencyscoop.CurrencyScoopClient;

@Configuration
public class FeignConfig {

    @Bean
    public CurrencyScoopClient currencyScoopClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(CurrencyScoopClient.class, "https://api.currencyscoop.com/v1");
    }
}
