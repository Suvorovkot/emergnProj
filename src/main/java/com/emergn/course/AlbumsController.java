package com.emergn.course;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AlbumsController {
    private Database db;

    @RequestMapping(value = "/addArtist", method = RequestMethod.POST)
    public String addArtist(@PathVariable String firstName,
                           @PathVariable String lastName,
                           @PathVariable String stageName) {
        return null;
    }

    @RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
    public String addAlbum(@PathVariable String name,
                           @PathVariable Integer year,
                           @PathVariable Integer numberOfSong) {
        return null;
    }

    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public String developersList(@PathVariable String country, Model model) {
        return "null";
    }
}

