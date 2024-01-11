package it.zilfio.artistportrait.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.zilfio.artistportrait.service.ArtistPortraitService;
import it.zilfio.artistportrait.service.exception.ArtistPortraitException;
import it.zilfio.artistportrait.web.model.DateRangeDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/artistPortrait")
@RestController
@Tag(name = "ArtistPortraitController", description = "Artist Portrait provider")
public class ArtistPortraitController {

    private final ArtistPortraitService artistPortraitService;

    @Operation(summary = "Calculate seconds alive")
    @PostMapping("/secondsAlive")
    public ResponseEntity<Long> secondsAlive(@Valid @RequestBody DateRangeDto dateRangeDto) throws ArtistPortraitException {
        return ResponseEntity.ok().body(artistPortraitService.calculateSecondsAlive(dateRangeDto.getBirthDate(), dateRangeDto.getDeathDate()));
    }

    @Operation(summary = "Calculate days alive")
    @PostMapping("/daysAlive")
    public ResponseEntity<Long> daysAlive(@Valid @RequestBody DateRangeDto dateRangeDto) throws ArtistPortraitException {
        return ResponseEntity.ok().body(artistPortraitService.calculateDaysAlive(dateRangeDto.getBirthDate(), dateRangeDto.getDeathDate()));
    }
}
