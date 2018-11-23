package example.emergn.course.controllers;

import example.emergn.course.database.models.Artist;
import example.emergn.course.database.models.Countries;
import example.emergn.course.database.repo.ArtistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArtistsController {

    private ArtistRepository artistRepository;

    public ArtistsController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @PostMapping(value = "/createArtist")
    public String addArtist(@ModelAttribute Artist artist) {
        artistRepository.save(artist);
        return "redirect:/artists";
    }

    @PutMapping(value = "/editArt")
    public String editArt(@ModelAttribute Artist artist,
                          Model model) {
        artistRepository.save(artist);
        return "redirect:/artists";
    }

    @PutMapping(value = "/editArtist")
    public String editArtistPage(@ModelAttribute Artist artist,
                                 Model model) {
        model.addAttribute("origin", artist);
        return "editArtist";
    }

    @GetMapping(value = "/addArtist")
    public String addArtistPage(Model model) {
        return "addArtist";
    }

    @DeleteMapping(value = "/deleteArtist")
    public String deleteArtist(@RequestParam Integer id,
                               Model model) {
        artistRepository.deleteById(id);
        return "redirect:/artists";
    }

    @GetMapping("artists")
    public String getArtists(Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "artists";
    }

}
