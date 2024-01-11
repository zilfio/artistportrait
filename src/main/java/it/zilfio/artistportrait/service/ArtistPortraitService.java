package it.zilfio.artistportrait.service;

import it.zilfio.artistportrait.service.exception.ArtistPortraitException;

import java.time.LocalDateTime;

public interface ArtistPortraitService {

    long calculateSecondsAlive(LocalDateTime start, LocalDateTime end) throws ArtistPortraitException;

    long calculateDaysAlive(LocalDateTime birth, LocalDateTime death) throws ArtistPortraitException;
}
