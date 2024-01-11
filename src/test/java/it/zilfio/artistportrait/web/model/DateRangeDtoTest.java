package it.zilfio.artistportrait.web.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class DateRangeDtoTest {

    @Test
    public void testGetterAndSetter() {
        LocalDateTime birthDate = LocalDateTime.of(2024, Month.OCTOBER, 1, 0, 0, 0);
        LocalDateTime deathDate = LocalDateTime.of(2024, Month.OCTOBER, 2, 0, 0, 0);
        DateRangeDto rangeDto = new DateRangeDto(birthDate, deathDate);

        // Test iniziale
        assertEquals(birthDate, rangeDto.getBirthDate());
        assertEquals(deathDate, rangeDto.getDeathDate());

        // Modifica valori
        LocalDateTime birthDateUpdated = LocalDateTime.of(2024, Month.SEPTEMBER, 1, 0, 0, 0);
        LocalDateTime deathDateUpdated = LocalDateTime.of(2024, Month.SEPTEMBER, 2, 0, 0, 0);
        rangeDto.setBirthDate(birthDateUpdated);
        rangeDto.setDeathDate(deathDateUpdated);

        // Test dei setter
        assertEquals(birthDateUpdated, rangeDto.getBirthDate());
        assertEquals(deathDateUpdated, rangeDto.getDeathDate());
    }

    @Test
    public void testEquals() {
        DateRangeDto rangeDto1 = new DateRangeDto();
        rangeDto1.setBirthDate(LocalDateTime.of(2024, Month.OCTOBER, 1, 0, 0, 0));
        rangeDto1.setDeathDate(LocalDateTime.of(2024, Month.OCTOBER, 2, 0, 0, 0));

        DateRangeDto rangeDto2 = new DateRangeDto();
        rangeDto2.setBirthDate(LocalDateTime.of(2024, Month.OCTOBER, 1, 0, 0, 0));
        rangeDto2.setDeathDate(LocalDateTime.of(2024, Month.OCTOBER, 2, 0, 0, 0));

        DateRangeDto rangeDto3 = new DateRangeDto();
        rangeDto3.setBirthDate(LocalDateTime.of(2024, Month.SEPTEMBER, 30, 0, 0, 0));
        rangeDto3.setDeathDate(LocalDateTime.of(2024, Month.OCTOBER, 2, 0, 0, 0));

        // Test uguali
        assertEquals(rangeDto1, rangeDto2);

        // Test diversi
        assertNotEquals(rangeDto1, rangeDto3);
    }

    @Test
    public void testHashCode() {
        DateRangeDto rangeDto1 = new DateRangeDto();
        rangeDto1.setBirthDate(LocalDateTime.of(2024, Month.OCTOBER, 1, 0, 0, 0));
        rangeDto1.setDeathDate(LocalDateTime.of(2024, Month.OCTOBER, 2, 0, 0, 0));

        DateRangeDto rangeDto2 = new DateRangeDto();
        rangeDto2.setBirthDate(LocalDateTime.of(2024, Month.OCTOBER, 1, 0, 0, 0));
        rangeDto2.setDeathDate(LocalDateTime.of(2024, Month.OCTOBER, 2, 0, 0, 0));

        // Test hashCode
        assertEquals(rangeDto1.hashCode(), rangeDto2.hashCode());
    }

    @Test
    public void testToString() {
        DateRangeDto rangeDto1 = new DateRangeDto();
        rangeDto1.setBirthDate(LocalDateTime.of(2024, Month.OCTOBER, 1, 0, 0, 0));
        rangeDto1.setDeathDate(LocalDateTime.of(2024, Month.OCTOBER, 2, 0, 0, 0));

        // Test toString
        String expected = "DateRangeDto(birthDate=2024-10-01T00:00, deathDate=2024-10-02T00:00)";
        assertEquals(expected, rangeDto1.toString());
    }

}