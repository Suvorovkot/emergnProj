package example.emergn.course.controllers;

import example.emergn.course.database.models.Artist;
import example.emergn.course.database.models.Countries;
import example.emergn.course.database.repo.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArtistsController {

    @Autowired
    private ArtistRepository artistRepository;

    @RequestMapping(value = "/createArtist")
    public String addArtist(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String stageName,
                            @RequestParam String country,
                            Model model) {
        artistRepository.save(new Artist(firstName, lastName, stageName, Countries.valueOf(country.toUpperCase())));
        return "redirect:/artists";
    }
    @RequestMapping(value = "/editArt")
    public String editArt(@RequestParam Integer id,
                          @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String stageName,
                            @RequestParam String country,
                            Model model) {
        artistRepository.save(new Artist(id, firstName, lastName, stageName, Countries.valueOf(country.toUpperCase())));
        return "redirect:/artists";
    }

    @RequestMapping(value = "/editArtist", method = RequestMethod.GET)
    public String editArtistPage(@RequestParam Integer id,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam String stageName,
                                 @RequestParam String country,
                                 Model model) {
        model.addAttribute("origin", new Artist(id, firstName, lastName, stageName, Countries.valueOf(country.toUpperCase())));
        return "editArtist";
    }

    @RequestMapping(value = "/addArtist", method = RequestMethod.GET)
    public String addArtistPage(Model model) {
        return "addArtist";
    }

    @RequestMapping(value = "/deleteArtist", method = RequestMethod.GET)
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
