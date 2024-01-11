package it.zilfio.artistportrait.service.impl;

import it.zilfio.artistportrait.service.ArtistPortraitService;
import it.zilfio.artistportrait.service.exception.ArtistPortraitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArtistPortraitServiceImplTest {

    private ArtistPortraitService artistPortraitService;

    @BeforeEach
    void setUp() {
        artistPortraitService = new ArtistPortraitServiceImpl();
    }

    @Test
    public void testCalculateSecondsAlive() throws ArtistPortraitException {
        LocalDateTime birth = LocalDateTime.of(1947, 5, 1, 0, 0, 0);
        LocalDateTime death = LocalDateTime.of(2015, 9, 12, 0, 0, 0);

        final long secondsAlive = artistPortraitService.calculateSecondsAlive(birth, death);
        assertThat(secondsAlive).isEqualTo(2157494400L);
    }

    @Test
    public void testCalculateSecondsAliveInvalidDates() {
        // Data di morte precedente alla data di nascita
        LocalDateTime birthDateTime = LocalDateTime.of(2020, 1, 1, 0, 0, 0);
        LocalDateTime deathDateTime = LocalDateTime.of(1990, 1, 1, 0, 0, 0);

        // Verifica che venga lanciata un'eccezione
        assertThrows(ArtistPortraitException.class, () ->
                        artistPortraitService.calculateSecondsAlive(birthDateTime, deathDateTime),
                "Death date must be after birth date");
    }

    @Test
    public void testCalculateDaysAlive() throws ArtistPortraitException {
        LocalDateTime birth = LocalDateTime.of(1947, 5, 1, 0, 0, 0);
        LocalDateTime death = LocalDateTime.of(2015, 9, 12, 0, 0, 0);

        final long secondsAlive = artistPortraitService.calculateDaysAlive(birth, death);
        assertThat(secondsAlive).isEqualTo(24971L);
    }

    @Test
    public void testCalculateDaysAliveInvalidDates() {
        // Data di morte precedente alla data di nascita
        LocalDateTime birthDateTime = LocalDateTime.of(2020, 1, 1, 0, 0, 0);
        LocalDateTime deathDateTime = LocalDateTime.of(1990, 1, 1, 0, 0, 0);

        // Verifica che venga lanciata un'eccezione
        assertThrows(ArtistPortraitException.class, () ->
                        artistPortraitService.calculateDaysAlive(birthDateTime, deathDateTime),
                "Death date must be after birth date");
    }
}