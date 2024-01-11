package it.zilfio.artistportrait.web.controller;

import it.zilfio.artistportrait.service.ArtistPortraitService;
import it.zilfio.artistportrait.service.exception.ArtistPortraitException;
import it.zilfio.artistportrait.web.model.DateRangeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ArtistPortraitFrontController {

    private final ArtistPortraitService artistPortraitService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("dateRangeDto", new DateRangeDto());
        return "index";  // Carica la pagina index.html da templates
    }

    @PostMapping("/calculate")
    public String calculateLifespan(@ModelAttribute DateRangeDto dateRangeDto, Model model) throws ArtistPortraitException {

        // Calcola la differenza in secondi tra le due date e ore
        long seconds = artistPortraitService.calculateSecondsAlive(dateRangeDto.getBirthDate(), dateRangeDto.getDeathDate());

        // Aggiunge il risultato al modello per essere visualizzato nella pagina HTML
        model.addAttribute("seconds", seconds);

        return "index";  // Ritorna alla pagina index.html con il risultato
    }
}
