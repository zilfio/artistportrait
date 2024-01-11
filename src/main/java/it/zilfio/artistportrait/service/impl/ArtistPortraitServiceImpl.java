package it.zilfio.artistportrait.service.impl;

import it.zilfio.artistportrait.service.ArtistPortraitService;
import it.zilfio.artistportrait.service.exception.ArtistPortraitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
@Service
public class ArtistPortraitServiceImpl implements ArtistPortraitService {

    @Override
    public long calculateSecondsAlive(LocalDateTime birthDate, LocalDateTime deathDate) throws ArtistPortraitException {
        try {
            // Verifica che la data di morte sia successiva a quella di nascita
            if (deathDate.isBefore(birthDate)) {
                throw new IllegalArgumentException("Death date must be after birth date");
            }

            long seconds = ChronoUnit.SECONDS.between(birthDate, deathDate);
            log.info("Difference: {} seconds", seconds);
            return seconds;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ArtistPortraitException("Error in calculateDaysAlive", e);
        }
    }

    @Override
    public long calculateDaysAlive(LocalDateTime birthDate, LocalDateTime deathDate) throws ArtistPortraitException {
        try {
            // Verifica che la data di morte sia successiva a quella di nascita
            if (deathDate.isBefore(birthDate)) {
                throw new IllegalArgumentException("Death date must be after birth date");
            }

            long days = ChronoUnit.DAYS.between(birthDate, deathDate);
            log.info("Difference: {} days", days);
            return days;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ArtistPortraitException("Error in calculateDaysAlive", e);
        }
    }

}
