package example.emergn.course.controllers;

import example.emergn.course.database.models.Album;
import example.emergn.course.database.repo.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AlbumsController {
    @Autowired
    AlbumRepository albumRepository;


    @RequestMapping(value = "/albums")
    public String albumsByName(@RequestParam String artistName,
                               Model model) {

        model.addAttribute("albums", albumRepository.findByArtistName(artistName));
        return "albums";
    }

    @GetMapping("/addAlbum")
    public String addAlbumPage() {
        return "addAlbum";
    }

    @RequestMapping(value = "/createAlbum")
    public String addAlbum(@RequestParam String name,
                           @RequestParam Integer year,
                           @RequestParam Integer numberOfSongs,
                           @RequestParam String artistName,
                           Model model) {
        albumRepository.save(new Album(name, year, numberOfSongs, artistName));
        return "redirect:/albums?artistName=" + artistName;

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

