package it.pgart.artistportrait.service.config;

import it.pgart.artistportrait.service.ArtistPortraitService;
import it.pgart.artistportrait.service.impl.ArtistPortraitServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public ArtistPortraitService artistPortraitService() {
        return new ArtistPortraitServiceImpl();
    }

}
