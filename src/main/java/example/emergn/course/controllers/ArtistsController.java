package example.emergn.course.controllers;

import example.emergn.course.database.models.Artist;
import example.emergn.course.database.models.Countries;
import example.emergn.course.database.repo.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtistsController {

    @Autowired
    ArtistRepository artistRepository;

    @RequestMapping(value = "/createArtist", method = RequestMethod.POST)
    public void addArtist(@PathVariable String firstName,
                           @PathVariable String secondName,
                           @PathVariable String stageName,
                           @PathVariable String country,
                           Model model) {
        Artist artistToAdd = new Artist(firstName, secondName, stageName, Countries.valueOf(country.toUpperCase()));
        artistRepository.save(artistToAdd);
        // Тут может быть ваше всплывающее окошко
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

    @RequestMapping(value = "/deleteArtist", method = RequestMethod.POST)
    public void deleteArtist(@PathVariable Integer id,
                              Model model) {
        artistRepository.deleteById(id);
        // Тут может быть ваше всплывающее окошло
    }

}
