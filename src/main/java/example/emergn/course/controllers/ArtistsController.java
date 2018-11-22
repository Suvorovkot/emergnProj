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
    ArtistRepository artistRepository;

    @RequestMapping(value = "/createArtist", method = RequestMethod.POST)
    public String addArtist(@RequestParam String firstName,
                            @RequestParam String secondName,
                            @RequestParam String stageName,
                            @RequestParam String country,
                            Model model) {
        Artist artistToAdd = new Artist(null, firstName, secondName, stageName, Countries.valueOf(country.toUpperCase()));
        artistRepository.save(artistToAdd);
        // Тут может быть ваше всплывающее окошко
        return "redirect:/artists";

    }

    @RequestMapping(value = "/addArtist", method = RequestMethod.GET)
    public String addArtistPage() {
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
    public String getArtists(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "artists";
    }

}
