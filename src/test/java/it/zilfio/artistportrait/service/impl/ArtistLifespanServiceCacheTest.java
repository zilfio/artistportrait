package it.zilfio.artistportrait.service.impl;

import it.zilfio.artistportrait.service.ArtistPortraitService;
import it.zilfio.artistportrait.service.exception.ArtistPortraitException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ArtistLifespanServiceCacheTest {

    @Autowired
    private ArtistPortraitService artistLifespanService;

    @Test
    public void testCalculateLifespanWithCache() throws ArtistPortraitException {
        LocalDateTime birthDateTime = LocalDateTime.of(1990, 1, 1, 0, 0, 0);
        LocalDateTime deathDateTime = LocalDateTime.of(2020, 1, 1, 0, 0, 0);

        // Calcolo senza cache
        long firstCall = artistLifespanService.calculateSecondsAlive(birthDateTime, deathDateTime);

        // Verifica che il risultato sia corretto
        assertEquals(946684800L, firstCall);

        // Recupera il valore dalla cache
        long secondCall = artistLifespanService.calculateSecondsAlive(birthDateTime, deathDateTime);

        // Verifica che il valore sia stato preso dalla cache
        assertEquals(firstCall, secondCall);
    }
}
