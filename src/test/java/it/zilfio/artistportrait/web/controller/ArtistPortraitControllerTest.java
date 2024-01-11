package it.zilfio.artistportrait.web.controller;

import it.zilfio.artistportrait.service.ArtistPortraitService;
import it.zilfio.artistportrait.service.exception.ArtistPortraitException;
import it.zilfio.artistportrait.web.model.DateRangeDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArtistPortraitControllerTest {

    @Mock
    private ArtistPortraitService artistPortraitService;

    @InjectMocks
    private ArtistPortraitController artistPortraitController;

    @Test
    void testSecondsAlive() throws ArtistPortraitException {
        when(artistPortraitService.calculateSecondsAlive(any(), any())).thenReturn(1L);

        ResponseEntity<Long> response = artistPortraitController.secondsAlive(new DateRangeDto());
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(1L);

        verify(artistPortraitService).calculateSecondsAlive(any(), any());
        verifyNoMoreInteractions(artistPortraitService);
    }

    @Test
    void testDaysAlive() throws ArtistPortraitException {
        when(artistPortraitService.calculateDaysAlive(any(), any())).thenReturn(1L);

        ResponseEntity<Long> response = artistPortraitController.daysAlive(new DateRangeDto());
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(1L);

        verify(artistPortraitService).calculateDaysAlive(any(), any());
        verifyNoMoreInteractions(artistPortraitService);
    }
}