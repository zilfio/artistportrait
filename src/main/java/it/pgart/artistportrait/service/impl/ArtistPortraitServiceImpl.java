package it.pgart.artistportrait.service.impl;

import it.pgart.artistportrait.service.ArtistPortraitService;
import it.pgart.artistportrait.service.exception.ArtistPortraitException;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ArtistPortraitServiceImpl implements ArtistPortraitService {

    @Override
    public long calculateSecondsAlive(Date birth, Date death) throws ArtistPortraitException {
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(birth);
            cal1.set(Calendar.HOUR, 0);
            cal1.set(Calendar.MINUTE, 0);
            cal1.set(Calendar.SECOND, 0);
            System.out.println("Birth: " + cal1.getTime());

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(death);
            cal2.set(Calendar.HOUR, 0);
            cal2.set(Calendar.MINUTE, 0);
            cal2.set(Calendar.SECOND, 0);
            System.out.println("Death: " + cal2.getTime());

            long diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
            log.info("Time difference in seconds: {}", TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS));
            return TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ArtistPortraitException("Error in execute", e);
        }
    }

    @Override
    public long calculateDaysAlive(Date birth, Date death) throws ArtistPortraitException {
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(birth);
            cal1.set(Calendar.HOUR, 0);
            cal1.set(Calendar.MINUTE, 0);
            cal1.set(Calendar.SECOND, 0);
            System.out.println("Birth: " + cal1.getTime());

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(death);
            cal2.set(Calendar.HOUR, 0);
            cal2.set(Calendar.MINUTE, 0);
            cal2.set(Calendar.SECOND, 0);
            System.out.println("Death: " + cal2.getTime());

            long diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();
            log.info("Time difference in days: {}", TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ArtistPortraitException("Error in execute", e);
        }
    }

}
