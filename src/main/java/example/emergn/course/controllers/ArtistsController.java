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

    @RequestMapping(value = "/addArtist", method = RequestMethod.GET)
    public String addArtistPage(Model model) {
        model.addAttribute("artist", new Artist());
        return "addArtist";
    }

    @RequestMapping(value = "/updateArtist", method = RequestMethod.POST)
    public void updateArtist(@PathVariable String firstName,
                             @PathVariable String secondName,
                             @PathVariable String stageName,
                             @PathVariable Countries country,
                             Model model) {
        // Как делать юпдейт артиста?
    }

    @RequestMapping(value = "/deleteArtist", method = RequestMethod.GET)
    public String deleteArtist(@RequestParam Integer id,
                               Model model) {
        System.out.println("KEKEK");
        artistRepository.deleteById(id);
        return "redirect:/artists";
    }

    @GetMapping("artists")
    public String getArtists(Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "artists";
    }

}
