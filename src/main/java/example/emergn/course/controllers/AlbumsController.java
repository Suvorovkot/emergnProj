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
    public void addAlbum(@PathVariable String name,
                           @PathVariable Integer year,
                           @PathVariable Integer numberOfSong,
                           @PathVariable String stageName,
                           Model model) {

    }

    @RequestMapping(value = "/updateAlbum", method = RequestMethod.POST)
    public void updateAlbum(@PathVariable String name,
                              @PathVariable Integer year,
                              @PathVariable Integer numberOfSong,
                              @PathVariable String stageName,
                              Model model) {

    }

    @RequestMapping(value = "/deleteAlbum", method = RequestMethod.POST)
    public void deleteAlbum(@PathVariable String name,
                              @PathVariable String stageName,
                              Model model) {

    }

    @RequestMapping(value = "/getAlbumByName", method = RequestMethod.POST)
    public void getAlbumByName(@PathVariable String name,
                                 Model model) {
    }

    @RequestMapping(value = "/getAlbumsByArtist", method = RequestMethod.POST)
    public void getAlbumsByArtist(@PathVariable String stageName,
                                    Model model) {
    }

//    @RequestMapping(value = "/getAlbumsByArtistAndName", method = RequestMethod.POST)
//    public void getAlbumsByArtistAndName(@PathVariable String name,
//                                           @PathVariable String stageName,
//                                           Model model) {
//
//    }

}

