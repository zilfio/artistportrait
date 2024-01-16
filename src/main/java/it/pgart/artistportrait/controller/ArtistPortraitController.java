package it.pgart.artistportrait.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.pgart.artistportrait.service.ArtistPortraitService;
import it.pgart.artistportrait.service.exception.ArtistPortraitException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/artistPortrait")
@RestController
@Tag(name = "ArtistPortraitController", description = "Artist Portrait provider")
public class ArtistPortraitController {

    private final ArtistPortraitService artistPortraitService;

    // GET http://localhost:8080/api/v1/artistPortrait/secondsAlive?birth=1947-05-01T00:00:00&death=2015-09-12T00:00:00
    @Operation(summary = "Calculate seconds alive")
    @GetMapping("/secondsAlive")
    public ResponseEntity<Long> secondsAlive(@Parameter(description = "Date of birth") @RequestParam("birth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime birth,
                                             @Parameter(description = "Date of death") @RequestParam("death") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime death) throws ArtistPortraitException {
        return ResponseEntity.ok().body(artistPortraitService.calculateSecondsAlive(birth, death));
    }

    // GET http://localhost:8080/api/v1/artistPortrait/daysAlive?birth=1947-05-01T00:00:00&death=2015-09-12T00:00:00
    @Operation(summary = "Calculate days alive")
    @GetMapping("/daysAlive")
    public ResponseEntity<Long> daysAlive(@Parameter(description = "Date of birth") @RequestParam("birth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime birth,
                                          @Parameter(description = "Date of death") @RequestParam("death") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime death) throws ArtistPortraitException {
        return ResponseEntity.ok().body(artistPortraitService.calculateDaysAlive(birth, death));
    }
}
