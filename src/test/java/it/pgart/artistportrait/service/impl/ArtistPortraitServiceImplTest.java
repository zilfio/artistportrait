package it.pgart.artistportrait.service.impl;

import it.pgart.artistportrait.service.ArtistPortraitService;
import it.pgart.artistportrait.service.exception.ArtistPortraitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static java.util.Calendar.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ArtistPortraitServiceImplTest {

    private ArtistPortraitService artistPortraitService;

    @BeforeEach
    void setUp() {
        artistPortraitService = new ArtistPortraitServiceImpl();
    }

    @Test
    public void testCalculate() throws ArtistPortraitException {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(DAY_OF_MONTH, 1);
        cal1.set(MONTH, MAY);
        cal1.set(YEAR, 1947);
        cal1.set(HOUR, 0);
        cal1.set(MINUTE, 0);
        cal1.set(SECOND, 0);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(DAY_OF_MONTH, 12);
        cal2.set(MONTH, SEPTEMBER);
        cal2.set(YEAR, 2015);
        cal2.set(HOUR, 0);
        cal2.set(MINUTE, 0);
        cal2.set(SECOND, 0);

        final long secondsAlive = artistPortraitService.calculateSecondsAlive(cal1.getTime(), cal2.getTime());
        assertThat(secondsAlive).isEqualTo(2157494400L);
    }
}