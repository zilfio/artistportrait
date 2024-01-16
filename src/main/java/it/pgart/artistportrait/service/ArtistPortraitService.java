package it.pgart.artistportrait.service;

import it.pgart.artistportrait.service.exception.ArtistPortraitException;

import java.time.LocalDateTime;

public interface ArtistPortraitService {

    long calculateSecondsAlive(LocalDateTime start, LocalDateTime end) throws ArtistPortraitException;

    long calculateDaysAlive(LocalDateTime birth, LocalDateTime death) throws ArtistPortraitException;
}
