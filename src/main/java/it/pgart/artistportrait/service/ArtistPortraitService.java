package it.pgart.artistportrait.service;

import it.pgart.artistportrait.service.exception.ArtistPortraitException;

import java.util.Date;

public interface ArtistPortraitService {

    long calculateSecondsAlive(Date start, Date end) throws ArtistPortraitException;

    long calculateDaysAlive(Date birth, Date death) throws ArtistPortraitException;
}
