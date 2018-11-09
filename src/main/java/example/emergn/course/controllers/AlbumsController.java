package example.emergn.course.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AlbumsController {

    /*  @RequestMapping(value = "/addArtist", method = RequestMethod.POST)
      public String addArtist(@PathVariable String firstName,
                              @PathVariable String lastName,
                              @PathVariable String stageName,
                              Model model) {
          return null;
      }
  */
    @RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
    public String addAlbum(@PathVariable String name,
                           @PathVariable Integer year,
                           @PathVariable Integer numberOfSong,
                           @PathVariable String stageName,
                           Model model) {
        return null;
    }

    @RequestMapping(value = "/updateAlbum", method = RequestMethod.POST)
    public String updateAlbum(@PathVariable String name,
                              @PathVariable Integer year,
                              @PathVariable Integer numberOfSong,
                              @PathVariable String stageName,
                              Model model) {
        return null;
    }

    @RequestMapping(value = "/deleteAlbum", method = RequestMethod.POST)
    public String deleteAlbum(@PathVariable String name,
                              @PathVariable String stageName,
                              Model model) {
        return null;
    }

    @RequestMapping(value = "/getAlbumByName", method = RequestMethod.POST)
    public String getAlbumByName(@PathVariable String name,
                                 Model model) {
        return null;
    }

    @RequestMapping(value = "/getAlbumsByArtist", method = RequestMethod.POST)
    public String getAlbumsByArtist(@PathVariable String stageName,
                                    Model model) {
        return null;
    }

    @RequestMapping(value = "/getAlbumsByArtistAndName", method = RequestMethod.POST)
    public String getAlbumsByArtistAndName(@PathVariable String name,
                                           @PathVariable String stageName,
                                           Model model) {
        return null;
    }

}

