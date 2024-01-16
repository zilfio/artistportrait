package it.pgart.artistportrait.service.impl;

import it.pgart.artistportrait.service.ArtistPortraitService;
import it.pgart.artistportrait.service.exception.ArtistPortraitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void testCalculateDaysAlive() throws ArtistPortraitException {
        LocalDateTime birth = LocalDateTime.of(1947, 5, 1, 0, 0, 0);
        LocalDateTime death = LocalDateTime.of(2015, 9, 12, 0, 0, 0);

        final long secondsAlive = artistPortraitService.calculateDaysAlive(birth, death);
        assertThat(secondsAlive).isEqualTo(24971L);
    }
}