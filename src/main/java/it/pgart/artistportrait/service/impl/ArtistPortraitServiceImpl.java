package it.pgart.artistportrait.service.impl;

import it.pgart.artistportrait.service.ArtistPortraitService;
import it.pgart.artistportrait.service.exception.ArtistPortraitException;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
public class ArtistPortraitServiceImpl implements ArtistPortraitService {

    @Override
    public long calculateSecondsAlive(LocalDateTime birth, LocalDateTime death) throws ArtistPortraitException {
        try {
            log.info("Birth: {}", birth);
            log.info("Death: {}", death);
            Duration duration = Duration.between(birth, death);
            log.info("Difference: {} seconds", duration.toSeconds());
            return duration.toSeconds();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ArtistPortraitException("Error in calculateSecondsAlive", e);
        }
    }

    @Override
    public long calculateDaysAlive(LocalDateTime birth, LocalDateTime death) throws ArtistPortraitException {
        try {
            log.info("Birth: {}", birth);
            log.info("Death: {}", death);
            Duration duration = Duration.between(birth, death);
            log.info("Difference: {} days", duration.toDays());
            return duration.toDays();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ArtistPortraitException("Error in calculateDaysAlive", e);
        }
    }

}
