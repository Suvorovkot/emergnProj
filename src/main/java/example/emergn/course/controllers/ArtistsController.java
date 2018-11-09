package example.emergn.course.controllers;

import example.emergn.course.database.models.Countries;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtistsController {
    @RequestMapping(value = "/addArtist", method = RequestMethod.POST)
    public void addArtist(@PathVariable String firstName,
                           @PathVariable String secondName,
                           @PathVariable String stageName,
                           @PathVariable Countries country,
                           Model model) {

    }

    @RequestMapping(value = "/updateArtist", method = RequestMethod.POST)
    public void updateArtist(@PathVariable String firstName,
                               @PathVariable String secondName,
                               @PathVariable String stageName,
                               @PathVariable Countries country,
                               Model model) {

    }

    @RequestMapping(value = "/deleteArtist", method = RequestMethod.POST)
    public void deleteArtist(@PathVariable String stageName,
                              Model model) {

    }

    @RequestMapping(value = "/getArtistByName", method = RequestMethod.POST)
    public void getArtistByName(@PathVariable String stageName,
                                 Model model) {

    }

//    @RequestMapping(value = "/getArtists", method = RequestMethod.POST)
//    public void getArtists(@PathVariable String stageName,
//                                Model model) {
//
//    }

}
